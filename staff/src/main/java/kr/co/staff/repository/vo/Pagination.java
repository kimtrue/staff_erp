package kr.co.staff.repository.vo;

import lombok.Data;

@Data
public class Pagination {
	private int listSize;
	private int rangeSize; 
	private int page;
	private int range;
	private int listCnt;
	private int pageCnt;
	private int startPage;
	private int startList;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	public Pagination() {
		this.page = 1;
		this.listSize = 10; // 초기값으로 목록개수를 10으로 셋팅
		this.rangeSize = 5; // 초기값으로 페이지범위를 5로 셋팅
	}
	
	public Pagination(int page, int listCnt) {
		this(page, listCnt, 10, 5);
		
	}

	public Pagination(int page, int listCnt, int listSize, int rangeSize) {
		this.page = page;
		this.listCnt = listCnt;
		this.listSize = listSize;
		this.rangeSize = rangeSize;
		pageInfo();
	}
	
	// page : 현재 페이지 - 현재 목록의 페이지 번호
	// range : 현재 페이지 범위 (각 페이지 범위 번호) -- 페이지 범위 블럭 번호 (범위 줄 번호) 예를 들면, 1~5(페이지범위)는 range가 1, 6~10은 range가 2 ...
	// listCnt : 총 게시물 수 (전체 게시물 개수)

	public int getStartList() {
		return this.startList = (page - 1) * listSize;
	}
	
	public void pageInfo() {
		// 전체 페이지수
		this.pageCnt = (int)Math.ceil(listCnt / (double)listSize);
		this.range = (int)Math.ceil(page / (double)rangeSize);
		// 시작 페이지
		this.startPage = (range - 1) * rangeSize + 1;
		// 끝 페이지
		this.endPage = range * rangeSize;
		// 게시판 시작번호
		this.startList = (page - 1) * listSize;
		// 이전 버튼 상태
		this.prev = range == 1 ? false : true;
		// 다음 버튼 상태
		this.next = pageCnt > endPage ? true : false;
		if (this.endPage > this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false;
		}
	}

	public void pageInfo(int page, int range, int listCnt) {
		this.page = page;
		this.range = range;
		this.listCnt = listCnt;
		
		// 전체 페이지수
		this.pageCnt = (int)Math.ceil(listCnt / (double)listSize);
		
		this.range = (int)Math.ceil(page / (double)rangeSize);
		
		
		// 시작 페이지
		this.startPage = (range - 1) * rangeSize + 1;
		
		// 끝 페이지
		this.endPage = range * rangeSize;
		
		// 게시판 시작번호
		this.startList = (page - 1) * listSize;
		
		// 이전 버튼 상태
		this.prev = range == 1 ? false : true;
		
		// 다음 버튼 상태
		this.next = pageCnt > endPage ? true : false;
		if (this.endPage > this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false;
		}
		
	}
	
	

}
