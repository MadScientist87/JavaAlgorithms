package Algorithms.StacksAndQueues;


import java.util.EmptyStackException;

public class ThreeInOneStack<T> {
    int LengthOfMasterArray = 0;
    int numberOfStacks = 0;

    public static class StackInfo {
        public int startIndex;
        public int endIndex;
        public int capacity = 0;
        public int numberOfCurrentItems = 0;
    }

    private Object[] backingArray;
    private StackInfo[] stackInfo;

    public Object[] getData()
    {
        return backingArray;
    }

    public ThreeInOneStack(int arrayDivision) {
        init(arrayDivision);
    }

    public void init(int arrayDivision) {
        numberOfStacks = arrayDivision;
        int section = 1;

        backingArray = new Object[arrayDivision];
        stackInfo = new StackInfo[arrayDivision];

        for (int i = 0; i < arrayDivision; i++) {
            stackInfo[i] = new StackInfo();
            stackInfo[i].startIndex = i;
            stackInfo[i].endIndex = section + i - 1;
            stackInfo[i].capacity = section;
        }
        LengthOfMasterArray = 0;
    }

    public void push(T item, int stackNumber) {
        // check to make sure stack is valid
        if (stackNumber > numberOfStacks || stackNumber < 0)
            throw new IllegalArgumentException("Number of stacks " + stackNumber + " is invalid");

        // translate to array index for backing array
        stackNumber = stackNumber - 1;

        // Check if we have have an empty stack and capacity for adding a value
        // If not we create an temporary array one value larger and copy values
        if (stackInfo[stackNumber].numberOfCurrentItems < stackInfo[stackNumber].capacity) {
            backingArray[stackInfo[stackNumber].startIndex] = item;
            stackInfo[stackNumber].numberOfCurrentItems += 1;
        } else if (stackInfo[stackNumber].numberOfCurrentItems == stackInfo[stackNumber].capacity) {
            var tempArray = new Object[LengthOfMasterArray + 1];
            int j = 0;
            for (int i = 0; i < LengthOfMasterArray + 1; i++) {
                // If we run into the current stacks start index. place new item
                // into temp array and shift down other items in copy
                if (i == stackInfo[stackNumber].startIndex) {
                    stackInfo[stackNumber].startIndex = i;
                    tempArray[i] = item;
                    tempArray[i + 1] = backingArray[i];
                    stackInfo[stackNumber].endIndex++;
                    i++;
                    continue;
                }

                tempArray[i] = backingArray[j];
                j++;
            }

            stackInfo[stackNumber].numberOfCurrentItems++;
            stackInfo[stackNumber].capacity++;

            backingArray = tempArray;

            // Increase the start and end indexes all items below stack we inserted
            for (int i = stackNumber + 1; i < numberOfStacks; i++) {
                stackInfo[i].startIndex++;
                stackInfo[i].endIndex++;
            }
        }
        LengthOfMasterArray++;
    }

    public Object pop(int stackNumber) {
        stackNumber = stackNumber - 1;

        Object itemPopped;

        // check if wrong stacknumber given
        if (stackNumber > numberOfStacks || stackNumber < 0)
            throw new IllegalArgumentException("Number of stacks " + stackNumber + " is invalid");
        // throw error if trying to pop empty stack
        if (stackInfo[stackNumber].numberOfCurrentItems <= 0)
            throw new EmptyStackException();

        itemPopped = backingArray[stackInfo[stackNumber].startIndex];

        // reinitialize data structure if all elements from all stacks are popped
        if (LengthOfMasterArray == 1) {
            init(numberOfStacks);
            return itemPopped;
        }

        // Create a temp array that is one element less than the current array
        var tempArray = new Object[LengthOfMasterArray - 1];

        //copy from bottom where the element to be popped ends
        for (int i = stackInfo[stackNumber].endIndex + 1; i < LengthOfMasterArray; i++) {
            if (i == 0)
                tempArray[0] = backingArray[i];
            else
                tempArray[i - 1] = backingArray[i];
        }

        //Copy from top up until the element to be popped ends - 1
        for (int i = 0; i <= stackInfo[stackNumber].endIndex - 1; i++) {
            tempArray[i] = backingArray[i];
        }

        stackInfo[stackNumber].endIndex--;
        stackInfo[stackNumber].numberOfCurrentItems--;

        // Make sure the lowest capacity we hit is zero
        if (stackInfo[stackNumber].capacity > 0)
            stackInfo[stackNumber].capacity--;
        LengthOfMasterArray--;

        backingArray = tempArray;

        // shift the start and end index up by one for all other elements in the array
        for (int i = stackNumber + 1; i < numberOfStacks; i++) {
            if (stackInfo[i].startIndex > 0)
                stackInfo[i].startIndex--;
            if (stackInfo[i].endIndex > 0)
                stackInfo[i].endIndex--;
        }

        // Set the start and end index to the proper position once the current stack is emptied
        if (stackInfo[stackNumber].numberOfCurrentItems == 0) {
            if (stackNumber == 0) {
                stackInfo[stackNumber].startIndex = 0;
                stackInfo[stackNumber].endIndex = 0;
            } else {
                stackInfo[stackNumber].startIndex = stackInfo[stackNumber - 1].endIndex;
                stackInfo[stackNumber].endIndex = stackInfo[stackNumber - 1].endIndex;
            }
        }

        return itemPopped;
    }

    public Object Peek(int stackNumber) {
        if (backingArray[stackInfo[stackNumber].startIndex] == null)
            throw new EmptyStackException();
        return backingArray[stackInfo[stackNumber].startIndex];
    }

    public boolean isEmpty(int stackNumber) {
        return backingArray[stackInfo[stackNumber].startIndex] == null;
    }
}
