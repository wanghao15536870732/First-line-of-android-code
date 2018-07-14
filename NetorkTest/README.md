# NetworkTest
# 看精彩的世界——————使用网络技术
## 使用HttpURIConnection访问网络
```java
    private void sendRequestWithHttpURIConnection() {
//        开启线程发起网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try{
                    URL url = new URL("http://www.baidu.com");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
//                    下面对获取到的输入流进行读取
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null){
                        response.append(line);
                    }
                    showResponse(response.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (reader != null){
                        try{
                            reader.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    if (connection != null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }
```
##   使用OkHttp 访问网络
* Pull的解析方式
* SAX的解析方式
### 解析的主体代码：
```java
    private void sendRequestWithOkhttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
//                            访问地址为baidu的地址
//                            .url("http://www.baidu.com")
//                            指定访问的服务器地址是电脑本机
                            .url("http://10.0.0.2/get_data.xml")
                            .build();
                    Response response = client.newCall(request).execute();
                    String responseData = response.body().string();

//                    showResponse(responseData);

//                    Pull的解析方式
//                    parseXMLWithPull(responseData);
//
//                    SAX的解析方式
                    parseXMLWithSAX(responseData);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
```

## * Pull的解析方式
```java
    private void parseXMLWithPull(String xmlData) {
        try{
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            int eventType = xmlPullParser.getEventType();
            String id = "";
            String name = "";
            String version = "";
            while (eventType == xmlPullParser.END_DOCUMENT){
                String nodeName = xmlPullParser.getName();
                switch(eventType){
//                    开始解析摸个节点
                    case XmlPullParser.START_TAG:{
                        if ("id".equals(nodeName)){
                            id = xmlPullParser.nextText();
                        }else if ("name".equals(nodeName)){
                            name = xmlPullParser.nextText();
                        }else if ("version".equals(nodeName)){
                            version = xmlPullParser.nextText();
                        }
                        break;
                    }
//                    完成解析某个节点
                    case XmlPullParser.END_TAG:{
                        if ("app".equals(nodeName)){
                            Log.d("MainActivity","id id " + id);
                            Log.d("MainActivity","name is " + name);
                            Log.d("MainActivity","version is " + version);
                        }
                        break;
                    }
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

```
## SAX的解析方式
* 首先需要建立一个类继承DefaulyHander,并重写父类的5个方法
```java 
public class ContentHander extends DefaultHandler{
    
}

public void startDocument() throws SAXException {

}
public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

}

public void characters(char[] ch, int start, int length) throws SAXException {

}

public void endElement(String uri, String localName, String qName) throws SAXException {

}

public void endDocument() throws SAXException {

}
```


* 再在MainActivity里面做如下修改：
```java
private void parseXMLWithSAX(String xmlData) {

        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader xmlReader = factory.newSAXParser().getXMLReader();
            ContentHander hander = new ContentHander();
//            将ContentHander的实例设置到XMLReader中
            xmlReader.setContentHandler(hander);
//            开始执行解析
            xmlReader.parse(new InputSource(new StringReader(xmlData)));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
```
