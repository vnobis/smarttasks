import java.util.*;

public class EmailBatching {


    public static Collection<Collection<Email>> batchEmails1(Collection<Email> emails) {
        List<Collection<Email>> batchs = new LinkedList<Collection<Email>>();
        // add list as first batch

        batchs.add(new LinkedList<Email>());

        for (Email email : emails) {
            boolean wasAdded = false;
            for (Collection<Email> batch : batchs) {
                if (!doesButchContainRecipient(batch, email.getTo())) {
                    batch.add(email);
                    wasAdded = true;
                    break;
                }

            }
            if (!wasAdded) {
                Collection<Email> newBatch = new LinkedList<Email>();
                newBatch.add(email);
                batchs.add(newBatch);
            }
        }
        return batchs;
    }

    private static boolean doesButchContainRecipient(Collection<Email> batch, String emailAddress) {
        for (Email email : batch) {
            if (email.getTo().equals(emailAddress)) {
                return true;
            }
        }
        return false;
    }

    public static Collection<Collection<Email>> batchEmails2(Collection<Email> emails) {
        List<Map<String, Email>> tempBatches = new LinkedList<Map<String, Email>>();
        // Maps will contain pairs <EmailsAddress, EmailObject>

        // add first temporary batch
        tempBatches.add(new HashMap<String, Email>());

        for (Email email : emails) {
            boolean wasAdded = false;
            for (Map<String, Email> batch : tempBatches) {
                if (!batch.containsKey(email.getTo())) {
                    batch.put(email.getTo(), email);
                    wasAdded = true;
                    break;
                }

            }
            if (!wasAdded) {
                Map<String, Email> newBatch = new HashMap<String, Email>();
                newBatch.put(email.getTo(), email);
                tempBatches.add(newBatch);
            }
        }
        List<Collection<Email>> batches = new LinkedList<Collection<Email>>();
        for (Map<String, Email> temporaryBatch : tempBatches) {
            batches.add(temporaryBatch.values());
        }
        return batches;
    }
}
