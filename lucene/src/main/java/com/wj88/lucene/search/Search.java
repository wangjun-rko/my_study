package com.wj88.lucene.search;

import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * Search
 *
 * @author huayu
 * @version 1.0
 * @description 查询
 * @date 2019/11/28 17:35
 */
public class Search {

    public static void search(String indexDir,String word) throws Exception{
        // 获取要查询的路径 索引所在的位置
        Directory directory = FSDirectory.open(Paths.get(indexDir));
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(indexReader);
        /**标准分词器 会自动去掉空格 is a the 等单词**/
        Analyzer analyzer = new StandardAnalyzer();
        // 查询解析器
        QueryParser parser = new QueryParser("contents",analyzer);
        // 解析要查询的内容 获取查询对象
        Query query = parser.parse(word);
        long startTime = System.currentTimeMillis();
        // 开始查询 查询前10条数据 将记录保存在docs中
        TopDocs docs = searcher.search(query,10);
        long endTime = System.currentTimeMillis();
        System.out.println("匹配："+word+"  耗时："+(endTime-startTime)+" 毫秒");
        System.out.println("查询到："+docs.totalHits+" 条记录");
        // 取出每条查询结果
        for (ScoreDoc scoreDoc:docs.scoreDocs){
            // scoreDoc.doc相当于docId  根据这个来获取文档
            Document document = searcher.doc(scoreDoc.doc);
            System.out.println(document.get("fullPath"));
        }
        indexReader.close();
    }

    public static void main(String[] args) {
        String indexDir = "D:\\logs\\luncene";
        String word = "INFO";
        try {
            search(indexDir,word);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
