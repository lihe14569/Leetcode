char[] ch = haystack.toCharArray();
char[] needleCh = needle.toCharArray();
int result = -1;
if(needleCh.length == 0){
result = 0;
}
for(int i = 0; i<ch.length;i++){
if(ch[i]==needleCh[0] && i+needleCh.length-1 < ch.length){
boolean ifContains = true;
for(int j = 0; j < needleCh.length-1; j++){
if(ch[i+j+1] == needleCh[j+1]){
continue;
}
else{
ifContains = false;
break;
}
}
if(ifContains){
result = i;
break;
}
}
}
return result;
}
}
​
```