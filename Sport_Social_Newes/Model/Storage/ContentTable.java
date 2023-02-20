package Model.Storage;

import java.util.ArrayList;

import Model.Content.Content;

public class ContentTable {
    ArrayList<Content>contentTable;

    public ContentTable() {
        contentTable = new ArrayList<Content>();
    }

    public ArrayList<Content> getContentTable() {
        return contentTable;
    }

    public Content getContent(int index) {
        return contentTable.get(index);
    }
}
