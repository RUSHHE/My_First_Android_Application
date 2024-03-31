    package com.example.myapplication;

    import android.content.Context;
    import android.os.Bundle;

    import androidx.annotation.NonNull;
    import androidx.annotation.Nullable;
    import androidx.constraintlayout.widget.ConstraintLayout;
    import androidx.fragment.app.Fragment;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import android.util.Log;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;

    import com.example.myapplication.databinding.FragmentQzoneBinding;
    import com.google.android.material.bottomsheet.BottomSheetBehavior;

    /**
     * @author rushhe
     */
    public class QZoneFragment extends Fragment {
        boolean isFABOpen = false;
        FragmentQzoneBinding binding;
        private RecyclerView recyclerView;
        private QZoneRecyclerViewAdapter QZoneRecyclerViewAdapter;
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            binding = FragmentQzoneBinding.inflate(inflater, container, false);
            recyclerView = binding.momentRecyclerView;
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);
            QZoneRecyclerViewAdapter = new QZoneRecyclerViewAdapter();
            recyclerView.setAdapter(QZoneRecyclerViewAdapter);
            binding.qzoneActionButton.setOnClickListener(view -> {
                if(!isFABOpen){
                    showFABMenu();
                }else{
                    closeFABMenu();
                }
            });

            BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheet);
            bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {

                @Override
                public void onStateChanged(@NonNull View view, int i) {
                    if (i == BottomSheetBehavior.STATE_EXPANDED || i == BottomSheetBehavior.STATE_COLLAPSED || i == BottomSheetBehavior.STATE_DRAGGING) {
                        binding.qzone.setClickable(false);
                    }
                }

                @Override
                public void onSlide(@NonNull View view, float v) {
                    float alpha = 1 - v;
                    binding.qzone.setAlpha(alpha);
                }
            });

            binding.qzoneActionButton1.setOnClickListener(view -> {
                bottomSheetBehavior.setHideable(false);
                bottomSheetBehavior.setPeekHeight(200, true);
                bottomSheetBehavior.setHideable(true);
            });
            return binding.getRoot();
        }

        private void showFABMenu(){
            isFABOpen=true;
            binding.qzoneActionButton1.setVisibility(View.VISIBLE);
            binding.qzoneActionButton2.setVisibility(View.VISIBLE);
            binding.qzoneActionButton1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
            binding.qzoneActionButton2.animate().translationY(-getResources().getDimension(R.dimen.standard_105));
        }

        private void closeFABMenu(){
            isFABOpen=false;
            binding.qzoneActionButton1.animate().translationY(0);
            binding.qzoneActionButton2.animate().translationY(0);
            binding.qzoneActionButton1.setVisibility(View.INVISIBLE);
            binding.qzoneActionButton2.setVisibility(View.INVISIBLE);
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
