package exercise_code;

public class heapsort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {56,2,7,934,4,7,35,34,23,54,24,5,65,46,35,3};
		heapSort(arr);
		print(arr);
	}
	//�ô���ѽ������������
	public static void heapSort(int [] arr) {
		if(arr == null && arr.length < 2) {
			return ;
		}
		//����������齨��Ϊ�����
		for(int i = 0 ; i < arr.length ;i++) {
			heapInsert(arr,i); //0~i
		}
		//��������ʵ�Ѿ�������һ����ȫ��������������������������������������е�˳�򲢲��ǰ��մ�С�����˳������
		//����Ҫ���ν�������������ȡ�����ŵ���β�����ܹ�����������
		print(arr);
		int heapSize = arr.length;
		//�����һ��Ԫ�������Ѷ�������(��arr[len]��arr[0]����)
		swap(arr, 0,--heapSize);//--��Ŀ���ǣ���һ�ν��о���ʹ�������ȱ��
		print(arr);
		while(heapSize > 0 ) {
			heapify(arr, 0, heapSize);//�ѷ����ı䣬���¹�����
			swap(arr, 0, --heapSize);//�Ѷ������ѵ�
			print(arr);
		}
	}
	
	
	
	//���������,��ֵ������(����)
	public static void heapInsert(int[] arr, int i) {
		//������
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
	
	
	
	//�����Ѿ����ڵĴ����,��Ϊindex����Ԫ�ر�С,������Ҫ�ı�ĳЩֵ�������±�ɴ����(�³�)
	public static void heapify(int [] arr,int index,int size) {
		//�õ�index���ӽڵ�
		int left = index * 2 + 1;
		while(left < size) {
			//��ȡ�ӽڵ�����ֵ��Ӧ����
			//left+1��֤������
			//arr[left+1] > arr[left]ѡ�����ҵ�����
			int largestIndex = (left + 1 < size && arr[left+1] > arr[left]) ? left + 1: left;
			//���ӽڵ����ֵ�븸�ڵ�Ƚ�,����arr[index]�Ƚ�
			largestIndex = arr[largestIndex] > arr[index] ? largestIndex : index;
			//��index > �ӽڵ����ֵ ����ѭ��
			if(largestIndex == index) {
				break;
			}
			
			//largest != index 
			swap(arr,largestIndex,index);
			//index�仯ֱ��Ҷ�ӽڵ�,��largestIndex == index�˳�ѭ��
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
//˼·��ֱ�ӽ�����������Ϊһ����ȫ��������������ײ���ӽڵ�Ϊi,�丸�ڵ����(i-1)/2
//��ԭ�������飬�ӵײ㿪ʼ�����жѻ�������֤�ӽ��С�ڸ��ڵ�
//֮�󣬽�ͷ��㣨arr[0]����ԭ������Ϊ���������������ȫ����������β�ڵ㽻���������ֵ���ں���
//Ȼ�����¶ѻ����飬���ȴ�length-1��ʼ
//ȡ����Ķѻ���ԭ���Ķѻ���һ������ʱ�ȱȽϸ��ڵ����ӽڵ�Ĵ�С�������Ҫ��������Ѵ���Ǹ�����븸�ڵ㽻������Ȼ
//�����ĵ�����һ���ӽڵ�Ҫһֱ���½��жѻ���ֱ��Ҷ�ӽ��

