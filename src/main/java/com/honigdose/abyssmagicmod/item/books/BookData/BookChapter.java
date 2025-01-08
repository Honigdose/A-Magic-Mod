package com.honigdose.abyssmagicmod.item.books.BookData;

public class BookChapter {

    private final String title;
    private final int pageIndex;

    public BookChapter(String title, int pageIndex) {
        this.title = title;
        this.pageIndex = pageIndex;
    }

    public String getTitle() {
        return title;
    }

    public int getPageIndex() {
        return pageIndex;
    }
}