package com.myapp.candyshop.exception.custom;

import com.myapp.candyshop.exception.service.CandyShopServiceException;

public class CandyAlreadyPresentException extends CandyShopServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CandyAlreadyPresentException() {
		// TODO Auto-generated constructor stub
	}

	public CandyAlreadyPresentException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CandyAlreadyPresentException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CandyAlreadyPresentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public CandyAlreadyPresentException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
