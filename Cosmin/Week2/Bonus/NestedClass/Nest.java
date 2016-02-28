package Week2.NestedClass;

public class Nest {

	private int x;

	public Nest() {
		this.x = 2;
		System.out.println("Nest Constructor.");
	}

	public class InnerPublic {
		@SuppressWarnings("unused")
		private int y;

		public InnerPublic() {
			this.y = 3;
			System.out.println("InnerPublic Constructor.");
		}

		public void getOuterClassMember() {
			System.out.println(x);
		}

		public void setOuterClassMember(int value) {
			x = value;
		}
	}

	public void getInnerClassMember() {
		// Outer class can't see inner class member
		// System.out.println(y);
	}

	@SuppressWarnings("unused")
	private class InnerPrivate {
		private int z;

		public InnerPrivate() {
			this.z = 4;
			System.out.println("InnerPrivate Constructor.");
		}
	}

}
