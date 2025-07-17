import java.util.ArrayList;

    /* ADT ที่เก็บเลขจำนวนเต็มใดๆ เรียงจากน้อยไปมาก และห้ามมี null หรือตัวเลขซ้ำ 
    */

public class IntegerSet {

    ArrayList<Integer> Numbers; // Rep
    // Rep Invariant (RI):
    //  - Number must not contain duplicate integer.
    //  - numbers in Number must be sorted in ascending order.
    //  - numbers in Number must not be null.
    //
    // Abstraction Function (AF):
    //  - AF(s) = the set of integer in the ArrayList<Integer> Number.

    public IntegerSet(){
        Numbers = new ArrayList<>();
        CheckRep();
        }
    
    private void CheckRep(){
        for (Integer Numbers : Numbers) {
            if(Numbers==null) // ไม่มีจำนวนเต็ม
            {
                throw new RuntimeException("Rep invariant violated!");
            }
        }
        for(int i=0;i<Numbers.size()-1;i++) // เรียงจากน้อยไปมาก
        {
            if(i > 0 && Numbers.get(i) >= Numbers.get(i+1)){
                throw new RuntimeException("Rep invariant violated!");
            }
        }
    }
    /** เพิ่มจำนวนเต็มเข้าเซต
        @param x จำนวนเต็มที่ต้องการเพิ่ม */
    public void add(Integer x){
        if(this.contains(x)){
        CheckRep();
        return;
    }


        int insertIndex = 0;
        for (int i = 0; i < Numbers.size(); i++) {
            if (x < Numbers.get(i)) {
                insertIndex = i;
                break; // พบตำแหน่งที่ควรแทรกแล้ว ออกจากลูป
            }
            insertIndex = i + 1; // ถ้า x มากกว่าหรือเท่ากับ element ปัจจุบัน ให้เลื่อนตำแหน่งไปเรื่อยๆ
        }

        // แทรก x ที่ตำแหน่งที่พบ
        Numbers.add(insertIndex, x);
        CheckRep();
    }
    /** เพิ่มจำนวนเต็มเข้าเซต
        @param x จำนวนเต็มที่ต้องการลบ */
    public void remove(Integer x){
        Numbers.remove(x);
        CheckRep();
    }

    /**
     * ตรวจสอบว่ามีจำนวนเต็มนี้อยู่ในเซตหรือไม่
     * @param x ตัวอักษรที่ต้องการตรวจสอบ
     * @return true หากมี x อยู่ในเซต, false หากไม่มี
     */
    public boolean contains(Integer x) {
        return Numbers.contains(x);
    }

    /** คืนค่าขนาดของเซต
        @return จำนวนสมาชิกในเซต */
    public int size() {
        return Numbers.size();
    }

    public String toString(){
        if (Numbers.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < Numbers.size(); i++) {
            sb.append(Numbers.get(i));
            if (i < Numbers.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}

