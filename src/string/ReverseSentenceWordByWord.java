package string;

public class ReverseSentenceWordByWord {
    
    public static void main(String[] args) {
        String str ="Java Concept Of The Day";
        StringBuffer buffer = new StringBuffer();
        String [] arr = str.split(" ");
        for(int i=arr.length-1 ;i>=0;i--){
            buffer.append(arr[i]+" ");
        }
        System.out.println(buffer.toString());

    }


}
