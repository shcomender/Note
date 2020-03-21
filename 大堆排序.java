package exercise_code;

public class heapsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {56,2,7,934,4,7,35,34,23,54,24,5,65,46,35,3};
		heapSort(arr);
		print(arr);
	}
	//用大根堆进行数组的排序
	public static void heapSort(int [] arr) {
		if(arr == null && arr.length < 2) {
			return ;
		}
		//将传入的数组建立为大根堆
		for(int i = 0 ; i < arr.length ;i++) {
			heapInsert(arr,i); //0~i
		}
		//到这里其实已经构成了一个完全二叉树，里面存放了整个数组的数，但是数组中的顺序并不是按照从小到大的顺序排列
		//所以要依次将大根堆里面的数取出来放到树尾，才能构成排序数组
		print(arr);
		int heapSize = arr.length;
		//将最后一个元素与大根堆顶部互换(即arr[len]和arr[0]互换)
		swap(arr, 0,--heapSize);//--的目的是，下一次进行就是使堆树长度变短
		print(arr);
		while(heapSize > 0 ) {
			heapify(arr, 0, heapSize);//堆发生改变，重新构建堆
			swap(arr, 0, --heapSize);//堆顶换到堆底
			print(arr);
		}
	}
	
	
	
	//建立大根堆,大值向上跑(上升)
	public static void heapInsert(int[] arr, int i) {
		//构建堆
		while(arr[i] > arr[(i-1)/2]) {
			swap(arr,i,(i-1)/2);
			i = (i-1)/2;
		}
	}
	public static void swap(int arr[],int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	
	
	//对于已经存在的大根堆,因为index索引元素变小,可能需要改变某些值才能重新变成大根堆(下沉)
	public static void heapify(int [] arr,int index,int size) {
		//得到index的子节点
		int left = index * 2 + 1;
		while(left < size) {
			//获取子节点的最大值对应索引
			//left+1保证不超限
			//arr[left+1] > arr[left]选择左右的条件
			int largestIndex = (left + 1 < size && arr[left+1] > arr[left]) ? left + 1: left;
			//将子节点最大值与父节点比较,即和arr[index]比较
			largestIndex = arr[largestIndex] > arr[index] ? largestIndex : index;
			//即index > 子节点最大值 跳出循环
			if(largestIndex == index) {
				break;
			}
			
			//largest != index 
			swap(arr,largestIndex,index);
			//index变化直到叶子节点,或largestIndex == index退出循环
			index = largestIndex;
			left = index * 2 + 1;
		}
	}
	private static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
//思路：直接将传入数组视为一个完全二叉树，所以最底层的子节点为i,其父节点就是(i-1)/2
//对原来的数组，从底层开始，进行堆化，即保证子结点小于父节点
//之后，将头结点（arr[0]）（原数组视为中序遍历构建的完全二叉树）与尾节点交换，将大的值放在后面
//然后重新堆化数组，长度从length-1开始
//取数后的堆化与原来的堆化不一样，此时先比较父节点与子节点的大小，如果需要交换，则把大的那个结点与父节点交换，当然
//被更改的哪那一个子节点要一直向下进行堆化，直到叶子结点

