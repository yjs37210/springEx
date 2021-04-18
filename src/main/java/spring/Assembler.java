package spring;

public class Assembler {

	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public Assembler() {
		memberDao = new MemberDao();
		/*
		 의존 객체를 수정하려면 위 코드만 수정하면 됨.
		 예를 들어, MemberDao 클래스를 상속받은 CachedMemberDao 클래스를 사용해야 한다면
		 memberDao = new CachedMemberDao(); 라고 하면 됨.
		 */
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}
	
	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}
	
}
