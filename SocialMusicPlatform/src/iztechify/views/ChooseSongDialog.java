package iztechify.views;

import iztechify.models.music.Song;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

public class ChooseSongDialog extends JDialog {
    public interface OnSongSelectedListener {
        void onSongSelected(Object[] data);
    }

    private JPanel contentPane;
    private JButton buttonOK;
    private JTable songTable;

    private OnSongSelectedListener listener;
    private DefaultTableModel songModel
            = new DefaultTableModel(new Object[]{"Title", "Album", "Artist"}, 0);

    public ChooseSongDialog(List<Song> songs, OnSongSelectedListener listener) {
        this.listener = listener;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        songTable.setModel(songModel);

        buttonOK.addActionListener(e -> onOK());

        for(Song song : songs) {
            songModel.addRow(new Object[]{song.getTitle(),
                    song.getAlbum().getTitle(),
                    song.getAlbum().getArtist().getName()});
        }
    }

    private void onOK() {
        int idx = songTable.getSelectedRow();
        if(idx != -1) {
            listener.onSongSelected(((Vector)songModel.getDataVector().get(idx)).toArray());
        }
        dispose();
    }
}
