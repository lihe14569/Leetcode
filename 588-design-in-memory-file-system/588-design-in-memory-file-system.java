class FileSystem {
    class File {
        //field
        Map<String, File> files;
        String content;
        boolean isFile;
        
        //constructor
        public File() {
            files = new HashMap<>();
            content = "";
            isFile = false;
        }
    }
    File root;
    public FileSystem() {
        root = new File();
    }
    
    public List<String> ls(String path) {
        List<String> list = new ArrayList<>();
        String[] route = path.split("/");
        File curr = root;
        for(int i = 1; i < route.length; i++) {
            curr = curr.files.get(route[i]);
        }
        if(curr.isFile) {
            list.add(route[route.length - 1]);
            return list;
        }
        list.addAll(curr.files.keySet());
        Collections.sort(list);
        return list;
    }
    
    public void mkdir(String path) {
        File file = root;
        String[] route = path.split("/");
        for(int i = 1; i < route.length; i++) {
            if(!file.files.containsKey(route[i])) {
                file.files.put(route[i], new File());
            }
            file = file.files.get(route[i]);
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