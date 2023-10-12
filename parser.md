# OAManager
Nothing
parsers: # array
 # - reg: ^.*$ 匹配所有订阅，或  - url: https://example.com/profile.yaml 指定订阅
- reg: ^.*$
#自定义规则添加
yalm:
  prepend-rules:
   - DOMIAN-KEYWORD,xtcmp,DIRECT
