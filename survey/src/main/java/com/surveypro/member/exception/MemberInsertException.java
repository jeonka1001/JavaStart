package com.surveypro.member.exception;

public class MemberInsertException extends MemberException {

	private static final long serialVersionUID = 1L;

	public static final int ERRNO = 1;
	public static final String MESSAGE = "ȸ������ �� ���� �߻�";

	public MemberInsertException() {
		super(ERRNO, MESSAGE);
	}

	@Override
	public void doException() {
		// TODO Auto-generated method stub

	}

}