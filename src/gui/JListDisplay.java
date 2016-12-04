package gui;

import model.Tournament;
import org.json.JSONException;
import singleton.challongeranks;

import javax.swing.*;
import java.io.IOException;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Created by Jonathan on 2016-12-03.
 */
public class JListDisplay extends JPanel {

    JList list;

    DefaultListModel model;

    int counter = 15;

    public JListDisplay() throws IOException, JSONException {
        setLayout(new BorderLayout());
        model = new DefaultListModel();
        list = new JList(model);
        JScrollPane pane = new JScrollPane(list);
        JButton addButton = new JButton("Add Element");
        JButton removeButton = new JButton("Remove Element");
        for (Tournament t : challongeranks.getInstance().getTournaments())
            model.addElement(t.getName());

        add(pane, BorderLayout.NORTH);

    }
}
