public class FiveLinkedList {

    private static int ind;
    private FiveNode head;
    public void add(Object data) {
        if (head == null) {
            head = new FiveNode(data);
        }
        FiveNode holder = new FiveNode(data);
        FiveNode latest = head;
        if (latest != null) {
            while (latest.getNext() != null) {
                latest = latest.getNext();
            }

            latest.setNext(holder);
        }
        addToIndex();
    }
    private static int getIndex() {
        return ind;
    }
    private static void addToIndex() {

        ind++;
    }
    private void subtractIndex() {
        ind--;
    }
    public void add(Object data, int index) {
        FiveNode holder = new FiveNode(data);
        FiveNode latest = head;
        if (latest != null) {
            for (int i = 0; i < index && latest.getNext() != null; i++) {
                latest = latest.getNext();
            }
        }
        holder.setNext(latest.getNext());
        latest.setNext(holder);
        addToIndex();
    }
    public Object get(int index)
    {
        if (index < 0)
            return null;
        FiveNode latest = null;
        if (head != null) {
            latest = head.getNext();
            for (int i = 0; i < index; i++) {
                if (latest.getNext() == null)
                    return null;
                latest = latest.getNext();
            }
            return latest.getData();
        }
        return latest;
    }
    public boolean remove(int index) {
        if (index < 1 || index > size())
            return false;
        FiveNode latest = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (latest.getNext() == null)
                    return false;
                latest = latest.getNext();
            }
            latest.setNext(latest.getNext().getNext());
            subtractIndex();
            return true;
        }
        return false;
    }
    public int size() {
        return getIndex();
    }
    public String toString() {
        String output = "";
        if (head != null) {
            FiveNode latest = head.getNext();
            while (latest != null) {
                output += "[" + latest.getData().toString() + "]";
                latest = latest.getNext();
            }
        }
        return output;
    }
    private class FiveNode {
        FiveNode next;
        Object data;
        public FiveNode(Object dataValue) {
            next = null;
            data = dataValue;
        }
        @SuppressWarnings("unused")
        public FiveNode(Object dataValue, FiveNode nextValue) {
            next = nextValue;
            data = dataValue;
        }
        public Object getData() {
            return data;
        }

        @SuppressWarnings("unused")
        public void setData(Object dataValue) {
            data = dataValue;
        }
        public FiveNode getNext() {
            return next;
        }
        public void setNext(FiveNode nextValue) {
            next = nextValue;
        }
    }

}