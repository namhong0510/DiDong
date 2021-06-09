public void loadAppList(Context context) {


        PackageManager pm = context.getPackageManager();
        Intent main = new Intent(Intent.ACTION_MAIN, null);
        main.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> packages = pm.queryIntentActivities(main, 0);

        for(ResolveInfo resolve_info : packages) {
            try {
                String package_name = resolve_info.activityInfo.packageName;
                ApplicationInfo info = pm.getApplicationInfo(package_name, PackageManager.GET_META_DATA);
                fetchAppDetails(pm, info);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void fetchAppDetails(PackageManager manager, ApplicationInfo info) {

        File apkFile = new File(info.publicSourceDir);
        long firstInstalled = 0;
        try {
            firstInstalled = manager.getPackageInfo(info.packageName, 0).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");


        // app infomation
        long sizeInByte = apkFile.length();
        String appName = info.loadLabel(manager).toString().trim();
        Drawable icon =  info.loadIcon(manager);
        String installedDate = format.format(new Date(firstInstalled));
        String packageName = packageName = info.packageName;

        Log.e("TAG", appName + " " + packageName + " " + sizeInByte + " - " + installedDate);
    }