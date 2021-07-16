package com.other.test;

/**
 *
 */
public class TestInterfacePara {

	interface Extendbroadable {
		public void inPut();
	}

	static class KeyBroad implements Extendbroadable {

		@Override
		public void inPut() {
			// TODO Auto-generated method stub
			System.out
					.println("this is KeyBroad class, implements Extendbroadable");
		}
	}

	static class NetCardBroad implements Extendbroadable {

		@Override
		public void inPut() {
			// TODO Auto-generated method stub
			System.out
					.println("this is NetBroad class, implements Extendbroadable");
		}

	}

	static class CheckBroad {
		public void getMainMessage(Extendbroadable ext) {
			ext.inPut();
		}
	}
	public static void main(String []arg)  {
		KeyBroad kb=new KeyBroad();    
		NetCardBroad ncb=new NetCardBroad();    
		CheckBroad cb=new CheckBroad();    
		cb.getMainMessage(kb);    
		cb.getMainMessage(ncb); 
	}
}
