package com.poly.dao;

import com.poly.bean.News;
import com.poly.request.NewsRequestEntity;
import com.poly.tool.ConstantManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDAO {

    @Autowired
    JdbcTemplate jdbc;

    protected List<News> getBySql(String sql) {
        return jdbc.query(sql, getRowMapper());
    }

    private RowMapper<News> getRowMapper() {
        return new BeanPropertyRowMapper<>(News.class);
    }

    public List<News> listNews(int type) {
        String sql = "SELECT news.id, news.title, news.active, news.save, "
                + "account.full_name as createdByName, news.avatar\n"
                + "FROM Db.news, Db.account\n"
                + "WHERE\n"
                + "account.id = news.created_by\n"
                + "AND\n"
                + "type = " + type + "\n"
                + "AND\n"
                + "news.company_id = '" + ConstantManager.COMPANY_ID + "'";
        return getBySql(sql);
    }

    public News getNewsById(String id) {
        String sql = "SELECT news.id, news.title, news.type, news.meta, news.content, news.description, "
                + "news.title_web, news.meta_description, news.url, news.avatar "
                + "FROM " + ConstantManager.DEFAULT_DB_NAME + ".news "
                + "WHERE news.id = ? ";
        return jdbc.queryForObject(sql, getRowMapper(), id);
    }

    public Boolean insertNews(News n) {
        String sql = "INSERT INTO " + ConstantManager.DEFAULT_DB_NAME + ".news "
                + "(id, title, meta, content, type, created_by, updated_by, "
                + "description, title_web, meta_description, save, url, company_id, avatar) "
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbc.update(sql, n.getId(), n.getTitle(), n.getMeta(), n.getContent(), n.getType(),
                n.getCreatedBy(), n.getUpdatedBy(), n.getDescription(), n.getTitleWeb(),
                n.getMetaDescription(), n.getSave(), n.getUrl(), n.getComapnyId(), n.getAvatar());
        try {
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateNews(NewsRequestEntity n) {
        String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".news "
                + "SET title = ?, meta = ?, content = ?, updated_by = ?, description = ?, "
                + "title_web = ?, meta_description = ?, save = ?, url = ?, avatar = ? "
                + "WHERE id = ?";
        jdbc.update(sql, n.getTitle(), n.getMeta(), n.getContent(), n.getCreatedBy(), n.getDescription(),
                n.getTitleWeb(), n.getMetaDescription(), n.getSave(), n.getUrl(), n.getLink(), n.getId());
        try {
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Boolean.FALSE;
        }
    }

    public Boolean updateStatusNews(News n) {
        String sql = "UPDATE " + ConstantManager.DEFAULT_DB_NAME + ".news "
                + "SET active = ? WHERE id = ?";
        jdbc.update(sql, n.getActive(), n.getId());
        try {
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    public Boolean deleteNews(String id) {
        String sql = "DELETE FROM " + ConstantManager.DEFAULT_DB_NAME + ".news "
                + "WHERE id = ?";
        jdbc.update(sql, id);
        try {
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
}
