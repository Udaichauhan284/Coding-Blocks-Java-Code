class student{
		private String name;
		private int age;
		public void setAge(int age) throws Exception {
			this.age=age;
		}
		public void getAge(){
			return age;
		}
	}
	public class client{
		public static void main(String args[]){
			student s1=new student();
			System.out.println("Hello");
			try{
				if(age<0){
					s1.setAge(-10);
					System.out.println("after statement");
				}
			}
			catch(Exception e){
				System.out.println("In the catch block");
			}
			System.out.println("bye");
			System.out.println(getAge());
		}
	}