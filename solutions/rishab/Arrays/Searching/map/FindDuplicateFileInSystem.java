package solutions.rishab.Arrays.Searching.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileInSystem {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> mp=new HashMap<>();
        for(int i=0;i<paths.length;i++){
            String path=paths[i];
            String[] tokens=path.split(" ");
            for(int j=1;j<tokens.length;j++){
                String token=tokens[j];
                int pos1=-1;
                int pos2=token.lastIndexOf(')');
                for(int k=pos2-1;k>=0;k--){
                    if(token.charAt(k)=='('){
                        pos1=k;
                        break;
                    }
                }
                String fileName = token.substring(0,pos1);
                String content = token.substring(pos1+1,pos2);
                List<String> list=mp.getOrDefault(content, new ArrayList<>());
                list.add(tokens[0]+"/"+fileName);
                mp.put(content,list);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(String key:mp.keySet()){
            List<String> list=mp.get(key);
            if(list.size()>1)
                ans.add(list);
        }
        return ans;
    }
}
