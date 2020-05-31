package algorithm._0155;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    private List<Integer> mList = new ArrayList<Integer>();
    private List<Integer> mMiniList = new ArrayList<Integer>();

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2);
        stack.push(0);
        stack.push(3);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }

    public void push(int x) {
        if (mList.size() == 0 || x <= getMin()) {
            mMiniList.add(x);
        }
        mList.add(x);
    }

    public void pop() {
        final int size = mList.size();
        if (size > 0) {
            int value = mList.remove(size - 1);
            int len = mMiniList.size();
            if (len > 0 && value == mMiniList.get(len - 1)) {
                mMiniList.remove(len - 1);
            }
        }
    }

    public int top() {
        final int size = mList.size();
        if (size > 0) {
            return mList.get(size - 1);
        }
        return -1;
    }

    public int getMin() {
        final int size = mMiniList.size();
        if (size > 0) {
            return mMiniList.get(size - 1);
        }
        return -1;
    }
}
