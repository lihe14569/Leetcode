class FileSystem {
    class File {
        String content;
        boolean isFile;
        Map<String, File> files;
        public File() {
            content = "";
            isFile = false;
            files = new HashMap<>();
        }
    }
    
    File root;
    public FileSystem() {
        root = new File();        
    }
    
    public List<String> ls(String path) {
        List<String> list = new ArrayList<>();
        File f = root;
        String[] pathArr = path.split("/");
        for(int i = 1; i < pathArr.length; i++) {
            if(!f.files.containsKey(pathArr[i])) {
                f.files.put(pathArr[i], new File());
            }
            f = f.files.get(pathArr[i]);
        }
        if(f.isFile) {
            list.add(pathArr[pathArr.length - 1]);
            return list;
        }
        list.addAll(f.files.keySet());
        Collections.sort(list);
        return list;
    }
    
    public void mkdir(String path) {
        File f = root;
        String[] route = path.split("/");
        for(int i = 1; i < route.length; i++) {
            if(!f.files.containsKey(route[i])) {
                f.files.put(route[i], new File());
            }
            f = f.files.get(route[i]);
        }
        
    }
    
    public void addContentToFile(String filePath, String content) {
        File f = root;
        String[] route = filePath.split("/");
        for(int i = 1; i < route.length; i++) {
            if(!f.files.containsKey(route[i])) {
                f.files.put(route[i], new File());
            }
            f = f.files.get(route[i]);
        }
        f.isFile = true;
        f.content += content;
    }
    
    public String readContentFromFile(String filePath) {
        File f = root;
        String[] route = filePath.split("/");
        for(int i = 1; i < route.length; i++) {
            f = f.files.get(route[i]);
        }
        return f.content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */