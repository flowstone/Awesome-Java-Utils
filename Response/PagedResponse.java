import enums.ResponseStatus;

public class PagedResponse extends BaseResponse {
    private int pageIndex;//当前页数
    private int pageSize;//分页条数
    private long count;//总条数

    public PagedResponse() {
    }

    public PagedResponse(ResponseStatus responseStatus) {
        super(responseStatus);
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
