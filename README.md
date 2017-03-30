# CirclePercentageView

CirclePercentageview gives the percentage value inside a circle. The percentage value can be get from the shaded color.


DEMO

![Alt text](https://github.com/MobileDews/CirclePercentageView/blob/master/circlepercentageview.png?raw=true "Optional Title")


GRADLE

Step 1. Add the JitPack repository to your root build.gradle

           allprojects {
	         repositories {
		          ...
		            maven { url 'https://jitpack.io' }
	          }
         }
         
Step 2. Add the dependency
         
         dependencies {
         	        compile 'com.github.MobileDews:CirclePercentageView:1.0.1'
         	}
         	
USAGE
         	
         	<com.techdew.library.CirclePercentageView
                    android:id="@+id/percentview"
                    android:layout_width="200dp"
                    custom:base_color="@color/colorAccent"
                    custom:percentage_color="@color/colorPrimary"
                    android:layout_centerInParent="true"
                    android:layout_height="200dp" />
                    
                    
Add the following code to the MainActivity.java

                     public class MainActivity extends AppCompatActivity {
                        CirclePercentageView circlePercentView;
                        int val;
                    
                        @Override
                        protected void onCreate(Bundle savedInstanceState) {
                            super.onCreate(savedInstanceState);
                            setContentView(R.layout.activity_main);
                    
                            circlePercentView = (CirclePercentageView) findViewById(R.id.percentview);
                    
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                    
                                    for (val = 0; val <= 100; val++) {
                                        Handler mainHandler = new Handler(getApplicationContext().getMainLooper());
                                        mainHandler.post(new Runnable() {
                                            @Override
                                            public void run() {
                    
                                                circlePercentView.setPercentage(val);
                    
                                            }
                                        });
                                        try {
                                            Thread.sleep(100);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                    
                                    }
                                }
                            }).start();
                    
                    
                        }
                    }
                    
                    
                    
                    