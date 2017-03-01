
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.util.Log;
//
//import com.google.firebase.auth.FirebaseAuth;
//
//
//

//
//public abstract class BaseFragment extends Fragment {
//
//    public static final String PRIMARY_ARG_TAG = "PRIMARY_ARG_TAG";
//    private static final String TAG = "Base Fragment";
//
//
//
//    public Object getData() {
//        return data;
//    }
//
//    public void setData(Object data) {
//        this.data = data;
//    }
//
//    Object data;
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }
//
//
//    protected boolean hasPrimaryArgument(){
//        return null!=getArguments().getString(BaseFragment.PRIMARY_ARG_TAG);
//    }
//
//    protected String getPrimaryArgument(){
//        return getArguments().getString(BaseFragment.PRIMARY_ARG_TAG);
//    }
//
//}
