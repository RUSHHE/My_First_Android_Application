    package com.example.myapplication;

    import android.content.Context;
    import android.os.Bundle;

    import androidx.annotation.NonNull;
    import androidx.annotation.Nullable;
    import androidx.fragment.app.Fragment;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import android.util.Log;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;

    public class QZoneFragment extends Fragment {
        private RecyclerView recyclerView;
        private QZoneRecyclerViewAdapter QZoneRecyclerViewAdapter;
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_qzone, container, false);

            recyclerView = view.findViewById(R.id.momentRecyclerView);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            QZoneRecyclerViewAdapter = new QZoneRecyclerViewAdapter();
            recyclerView.setAdapter(QZoneRecyclerViewAdapter);
            return view;
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
        }

        /*
         * 以下是生命周期方法
         */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.d("MomentFragment", "onCreate() called");
        }

        @Override
        public void onAttach(@NonNull Context context) {
            super.onAttach(context);
            Log.d("MomentFragment", "onAttach() called");
        }

        @Override
        public void onDetach() {
            super.onDetach();
            Log.d("MomentFragment", "onDetach() called");
        }

        @Override
        public void onStart() {
            super.onStart();
            Log.d("MomentFragment", "onStart() called");
        }

        @Override
        public void onResume() {
            super.onResume();
            Log.d("MomentFragment", "onResume() called");
        }

        @Override
        public void onPause() {
            super.onPause();
            Log.d("MomentFragment", "onPause() called");
        }

        @Override
        public void onStop() {
            super.onStop();
            Log.d("MomentFragment", "onStop() called");
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            Log.d("MomentFragment", "onDestroyView() called");
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.d("MomentFragment", "onDestroy() called");
        }

        @Override
        public void onSaveInstanceState(@NonNull Bundle outState) {
            super.onSaveInstanceState(outState);
            Log.d("MomentFragment", "onSaveInstanceState() called");
        }

        @Override
        public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
            super.onViewStateRestored(savedInstanceState);
            Log.d("MomentFragment", "onViewStateRestored() called");
        }
    }
