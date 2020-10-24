package ensa.ma.miniprojet.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ensa.ma.miniprojet.dao.ArticleJPA;
import ensa.ma.miniprojet.dao.AvieJPA;
import ensa.ma.miniprojet.dao.UserJPA;
import ensa.ma.miniprojet.entitie.Article;
import ensa.ma.miniprojet.entitie.Avie;
import ensa.ma.miniprojet.entitie.User;
import ensa.ma.miniprojet.service.ReviewService;


@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ArticleJPA articleRepo;
	@Autowired
	private AvieJPA avieRepo;
	@Autowired
	private UserJPA userRepo;
	@Override
	public boolean validateArticle(Article article) {
		boolean flag=false;
		if(article.getAffiliation()!=null) {
			if(article.getAuteur()!=null&& 
					(article.getCoAuteur()!=null&&!article.getCoAuteur().isEmpty())&& 
					(!article.getKeyWord().isEmpty()&&!article.getKeyWord().isEmpty())&& 
					(article.getResume()!=null||article.getResume().equals(""))&&
					(article.getContenu()!=null||article.getContenu().equals(""))
					) {
				article.setStatus("en attente");
				article=this.articleRepo.save(article);
				flag=true;
			}
			else {
				flag=false;
			}		
		}
		else {
			flag=false;
		}
		return flag;
	}
	@Override
	public boolean updateArticle(Article article) {
		Article loadArt=this.articleRepo.findById(article.getId()).get();
		if(loadArt.getStatus().equals("en cours")||loadArt.getStatus().equals("valide")) {
			//add log4j
			this.logData(loadArt, article,false);
			return false;
		}
		else {
			this.logData(loadArt, article,true);
			this.articleRepo.save(article);
			return true;
		}
	}
	public void logData(Article fAr,Article sAr,boolean saved){
		Logger logger = Logger.getLogger("MyLog");  
		SimpleFormatter formatter = new SimpleFormatter(); 
	    FileHandler fh;
		try {
			fh=new FileHandler("D:\\cours\\java\\mini-projet\\logFile.log");
			logger.addHandler(fh);
	        fh.setFormatter(formatter);
	        String info="";
	        if(!fAr.getAffiliation().equals(sAr.getAffiliation())) {
	        	info=info+" ancient affiliation: "+sAr.getAffiliation()+"///// nouvelle affiliation: "+fAr.getAffiliation();
	        }
	        if(!fAr.getTitre().equals(sAr.getTitre())) {
	        	info=info+" ancient titre: "+sAr.getTitre()+"///// nouveau titre: "+fAr.getTitre();
	        }
	        if(!fAr.getContenu().equals(sAr.getContenu())) {
	        	info=info+" ancient contenu: "+sAr.getContenu()+"///// nouveau contenu: "+fAr.getContenu();
	        }
	        if(saved) {
	        	info=info+" ====>saved";
	        }
	        if(!saved) {
	        	info=info+" ====>not saved";
	        }
	        logger.info(info);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
