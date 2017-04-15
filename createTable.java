import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class createTable {
     JFrame frame = new JFrame();
    JTable table;
    public createTable(int j,List<Object> data)
    {
        if(j==1)
        {
            Object rowData[][];
            Object columnNames[]={"Book Title"};
        	for(int i=0;i<data.size();i++)
        	{
        		rowData[i][0] =(Object) data.get(i).getBook_Title();
        	}
            
        	
            table = new JTable(rowData, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.setSize(300, 150);
            frame.setVisible(true);
        }
    }

}