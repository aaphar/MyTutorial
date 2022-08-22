package oop.Abstraction.Challange;

public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.rightLink;
    }

    @Override
    ListItem setNext(ListItem item) {
        this.rightLink = item;
        return this.rightLink;
    }

    @Override
    ListItem previous() {
        return this.leftLink;
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.leftLink = item;
        return this.leftLink;
    }

    /**
     * @param item passed item
     * @return 0 is passed item equal value
     * @return 1 if passed value less than current value,
     * if the item parameter should sort after the object
     * @return -1 if passed value greater than current value,
     * if the item parameter should sort before the object
     */
    @Override
    int compareTo(ListItem item) {
        if (item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
            //compare one string to another string
        }
        return -1;
    }
}
