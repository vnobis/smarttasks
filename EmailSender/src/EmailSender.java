import java.util.*;

// Imagine that we have some code which relies on a third-party service to send bulk e-mails.
// This service can simply accept a large batch of e-mails accordingly. However, the service also has a bug in it: it does not allow us
// to specify a batch in which more than one e-mail is sent to the same recipient.
//
// So, we need to take the original input batch, and split it up into sub-batches,
// such that each sub-batch has the maximum number of e-mails, that are not addressed to the same recipient.

public class EmailSender {
    private enum RandomOrder {
        TRUE, FALSE
    }

    private static Collection<Email> generateTestData(RandomOrder shouldBeRandom) {
        Collection<Email> emails;
        if (shouldBeRandom == RandomOrder.TRUE) {
            emails = new HashSet<Email>(); // can be used if we need randomly ordered input data
        } else {
            emails = new LinkedList<Email>();
        }

        // First emails
        emails.add(new Email("test_01@gmail.com", "Hello, Test 01!"));
        emails.add(new Email("test_02@gmail.com", "Hello, Test 02!"));
        emails.add(new Email("test_03@gmail.com", "Hello, Test 03!"));
        emails.add(new Email("test_04@gmail.com", "Hello, Test 04!"));

        //Second emails
        emails.add(new Email("test_01@gmail.com", "Hello, Test 01. It is my second email."));
        emails.add(new Email("test_02@gmail.com", "Hello, Test 02. It is my second email."));
        emails.add(new Email("test_03@gmail.com", "Hello, Test 02. It is my second email."));

        //Third email
        emails.add(new Email("test_01@gmail.com", "Hello, Test 01. Don't forget to reply me!"));

        return emails;
    }

    private static void print(Collection<Collection<Email>> emailBatches) {
        int i = 1;
        for (Collection<Email> batch : emailBatches) {
            System.out.println("Email batch #" + i++);
            for (Email email : batch) {
                System.out.format("    [%s]%s\n", email.getTo(), email.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Collection<Email> emails = generateTestData(RandomOrder.FALSE); // switch to TRUE for randomly ordered input data
        // print input emails
        for (Email email : emails) {
            System.out.format("[%s]%s\n", email.getTo(), email.getMessage());
        }

        Collection<Collection<Email>> emailBatches1 = EmailBatching.batchEmails1(emails);
        print(emailBatches1);

        System.out.println("Second algorithm");
        // Due to usage of HashMap should be quicker then previous version
        Collection<Collection<Email>> emailBatches2 = EmailBatching.batchEmails2(emails);
        print(emailBatches2);
    }
}

/*
        [test_01@gmail.com]Hello, Test 01!
        [test_02@gmail.com]Hello, Test 02!
        [test_03@gmail.com]Hello, Test 03!
        [test_04@gmail.com]Hello, Test 04!
        [test_01@gmail.com]Hello, Test 01. It is my second email.
        [test_02@gmail.com]Hello, Test 02. It is my second email.
        [test_03@gmail.com]Hello, Test 02. It is my second email.
        [test_01@gmail.com]Hello, Test 01. Don't forget to reply me!
        Email batch #1
        [test_01@gmail.com]Hello, Test 01!
        [test_02@gmail.com]Hello, Test 02!
        [test_03@gmail.com]Hello, Test 03!
        [test_04@gmail.com]Hello, Test 04!
        Email batch #2
        [test_01@gmail.com]Hello, Test 01. It is my second email.
        [test_02@gmail.com]Hello, Test 02. It is my second email.
        [test_03@gmail.com]Hello, Test 02. It is my second email.
        Email batch #3
        [test_01@gmail.com]Hello, Test 01. Don't forget to reply me!
        Second algorithm
        Email batch #1
        [test_03@gmail.com]Hello, Test 03!
        [test_04@gmail.com]Hello, Test 04!
        [test_02@gmail.com]Hello, Test 02!
        [test_01@gmail.com]Hello, Test 01!
        Email batch #2
        [test_03@gmail.com]Hello, Test 02. It is my second email.
        [test_02@gmail.com]Hello, Test 02. It is my second email.
        [test_01@gmail.com]Hello, Test 01. It is my second email.
        Email batch #3
        [test_01@gmail.com]Hello, Test 01. Don't forget to reply me!

*/
