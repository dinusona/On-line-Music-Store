package model;

public interface StoreManager{
    //creat a methods
    public void addItem(MusicItem item);
    public void deleteItem (int itemId);
    public void printList();
    public void sortedList();
}

