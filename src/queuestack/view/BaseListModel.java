/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuestack.view;

import javax.swing.AbstractListModel;
import queuestack.MyList;

/**
 *
 * @author vvpetrov
 */
public class BaseListModel extends AbstractListModel<Integer> {
    public MyList list;

    public BaseListModel(MyList list) {
        this.list = list;
    }

    public BaseListModel() {}

    public void setList(MyList list) {
        this.list = list;
    }
    

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public Integer getElementAt(int index) {
        synchronized(list) {
        Integer i = (Integer) list.getIndex(index);
        return i;
        }
    }

    void addElement(int k) {
        list.push(k);
        fireIntervalAdded(this, 0, list.getSize());
    }

    void popElement() {
        list.pop();
        fireIntervalAdded(this, 0, list.getSize());
    }
    
}
