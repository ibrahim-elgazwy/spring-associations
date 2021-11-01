package com.spring.association.springAssociations.utils;

import org.springframework.data.domain.Page;

public class Pageing {
	private long totalItems;
	
	private int totalPages;
	
	private int currentPage;
	
	private int nextPage;
	
	private int previousPage;
	
	private Boolean hasNext;
	
	private Boolean hasPrevious;
	
	public Pageing() {}

	public Pageing(Page page) {
		totalItems = page.getTotalElements();
		totalPages = page.getTotalPages();
		currentPage = page.getNumber();
		hasNext = page.hasNext();
		hasPrevious = page.hasPrevious();
		nextPage = page.hasNext() ? (currentPage + 1) : 0;
		previousPage = page.hasPrevious() ? (currentPage - 1) : 0;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(int previousPage) {
		this.previousPage = previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(long totalItems) {
		this.totalItems = totalItems;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Boolean getHasNext() {
		return hasNext;
	}

	public void setHasNext(Boolean hasNext) {
		this.hasNext = hasNext;
	}

	public Boolean getHasPrevious() {
		return hasPrevious;
	}

	public void setHasPrevious(Boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
}
