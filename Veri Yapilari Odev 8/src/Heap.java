
public class Heap {
	
	class Node{
		int data;
		Node sol,orta,sag;
		
		public Node(int item) {
			this.data=item;
			sol=orta=sag=null;
		}
	}

	Node root;
	public Heap() {
		root=null;
	}
	
	void insert(int key) {
	    root = insertKey(root, key);
	  }

	Node insertKey(Node root,int key) {
		if(root==null) {
			root=new Node(key);
		}
		else if(root.sol==null) {
			root.sol=insertKey(root.sol,key);
		}
		else if(root.orta==null) {
			root.orta=insertKey(root.orta,key);
		}
		else if(root.sag==null) {
			root.sag=insertKey(root.sag,key);
		}
		else {
			if(root.sol!= null) {
				if(root.sol.sol==null) {
					root.sol.sol=insertKey(root.sol.sol,key);
				}
				else if(root.sol.orta==null) {
					root.sol.orta=insertKey(root.sol.orta,key);
				}
				else if(root.sol.sag==null) {
					root.sol.sag=insertKey(root.sol.sag,key);
				}
			}
			else if(root.orta!=null) {
				if(root.orta.sol==null) {
					root.orta.sol=insertKey(root.orta.sol,key);
				}
				else if(root.orta.orta==null) {
					root.orta.orta=insertKey(root.orta.orta,key);
				}
				else if(root.orta.sag==null) {
					root.orta.sag=insertKey(root.orta.sag,key);
				}
			}
			else if(root.sag!=null) {
				if(root.sag.sol==null) {
					root.sag.sol=insertKey(root.sag.sol,key);
				}
				else if(root.sag.orta==null) {
					root.sag.orta=insertKey(root.sag.orta,key);
				}
				else if(root.orta.sag==null) {
					root.sag.sag=insertKey(root.sag.sag,key);
				}
			}
		}
		
		//her eklediğimiz elemanla beraber burda başka metod cağırıp swapa bakıcaz
		return root;
	}
	
	void gezinti() {
		gezintiRec(root);
	}
	void gezintiRec(Node root) {
		if(root!=null) {
			gezintiRec(root.sol);
			gezintiRec(root.orta);
			gezintiRec(root.sag);
		}
	}
	
	public Heap.Node swap(int key) {
		Node parent=root;
		boolean elemanarama=true;
		while(elemanarama) {
			if(parent.sol!=null &&parent.orta!=null && parent.sag!=null) {
				if(parent.sol.data!=key && parent.orta.data!=key && parent.sag.data!=key) {
					parent=swap(parent.sol.data);
				}
			}
			
		}
		return parent;
	}
	
}
