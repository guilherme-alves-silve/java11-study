echo "Removing compiled sources..."
rm source1.txt source2.txt
rm -rf out/
echo "Removing module-info.java..."
rm src/common.widget/module-info.java
rm src/data.widget/module-info.java
echo "Finished!"