package com.honigdose.abyssmagicmod.item.books.BookData;

public class BookChapter {

    private final String title;
    private final String pageTag;

    public BookChapter(String title, String pageTag) {
        this.title = title;
        this.pageTag = pageTag;
    }

    public String getTitle() {
        return title;
    }

    public String getPageTag() {
        return pageTag;
    }
}
