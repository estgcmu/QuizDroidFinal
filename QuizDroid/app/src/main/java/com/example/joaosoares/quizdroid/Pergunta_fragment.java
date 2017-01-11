package com.example.joaosoares.quizdroid;



import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

public class Pergunta_fragment extends Fragment {

    public static Pergunta_fragment newInstance() {
        return new Pergunta_fragment();
    }

    public Pergunta_fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pergunta_fragment, container, false);
    }
}