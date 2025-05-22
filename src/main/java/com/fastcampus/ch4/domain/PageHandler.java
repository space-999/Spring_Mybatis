package com.fastcampus.ch4.domain;

public class PageHandler {
    int totalCnt; //총 개시물 개수
    int pageSize; //한 페이지 크기
    int naviSize = 10; // 페이지 내비게이션 크기
    int totalPage; //전체 페이지 수
    int page; // 현재 페이지
    int beginPage; // 내비게이션 첫번째 페이지
    int endPage; // 내비게이션 마지막 페이지
    boolean showPrev; //이전 페이지로 이동하는 링크 보여줄지 여부
    boolean showNext; //다음 페이지로 이동하느 링크 보여줄지 여부

    public PageHandler(int totalCnt, int page) {
        this(totalCnt, page, 10);
    }

    public PageHandler(int totalCnt, int page, int pageSize) {
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;

        totalPage = (int) Math.ceil(totalCnt / (double)pageSize);
        beginPage = (page / naviSize) * naviSize + 1;
        endPage = Math.min(beginPage + naviSize - 1, totalPage);
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
    }

    void print() {
        System.out.println("page = " + page);
        System.out.print(showPrev ? "[PREV]" : "");
        for (int i = beginPage; i <= endPage; i++) {
            System.out.print(i + " ");
        }
        System.out.println(showNext ? "[NEXT]" : "");
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "totalCnt=" + totalCnt +
                ", pageSize=" + pageSize +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", page=" + page +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}
