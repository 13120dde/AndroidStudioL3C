package a13solutions.androidstudiol3c;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InstructionFragment extends Fragment implements CustonFragment {


    private TextView tvWhatToDo, tvContent;
    private Controller controller;

    public InstructionFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_instruction, container, false);
        instantiateComponents(view);
        populateInfo(controller.getWhatToDo());
        return view;
    }

    @Override
    public void instantiateComponents(View view) {
        tvWhatToDo = (TextView) view.findViewById(R.id.tv_whatToDo);
        tvContent = (TextView) view.findViewById(R.id.tv_content);

    }

    private void populateInfo(String whatToDo) {
        String[] vals = whatToDo.split(",");
        tvWhatToDo.setText(vals[0]);
        tvContent.setText(vals[1]);
    }

    public void setController(Controller controller){
        this.controller=controller;
    }

}
