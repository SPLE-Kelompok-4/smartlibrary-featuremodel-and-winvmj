package SmartLibrary.ebookdisplay.displaywithimage;
import java.util.*;

import vmj.routing.route.Route;
import vmj.routing.route.VMJExchange;

import SmartLibrary.ebookdisplay.core.EBookResourceDecorator;
import SmartLibrary.ebookdisplay.core.EBookImpl;
import SmartLibrary.ebookdisplay.core.EBookResourceComponent;

public class EBookResourceImpl extends EBookResourceDecorator {
    public EBookResourceImpl (EBookResourceComponent record) {
        super(record);
    }

    // @Restriced(permission = "")
    @Route(url="call/displaywithimage/save")
    public List<HashMap<String,Object>> save(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		EBookDisplayDisplayWithImage ebookdisplaydisplaywithimage = createEBookDisplayDisplayWithImage(vmjExchange);
		ebookdisplaydisplaywithimageRepository.saveObject(ebookdisplaydisplaywithimage);
		return getAllEBookDisplayDisplayWithImage(vmjExchange);
	}

    public EBookDisplay createEBookDisplayDisplayWithImage(VMJExchange vmjExchange){
		String image = (String) vmjExchange.getRequestBodyForm("image");
		
		EBookDisplayDisplayWithImage ebookdisplaydisplaywithimage = record.createEBookDisplayDisplayWithImage(vmjExchange);
		EBookDisplayDisplayWithImage ebookdisplaydisplaywithimagedeco = EBookDisplayDisplayWithImageFactory.createEBookDisplayDisplayWithImage("SmartLibrary.displaywithimage.core.EBookImpl", ebookdisplaydisplaywithimage, releaseDate, description, eBookTitle, eBookAuthor, bookID, ISBN, categories, ebookaccessimpl, createdAt
		image
		);
			return ebookdisplaydisplaywithimagedeco;
	}


    public EBookDisplay createEBookDisplayDisplayWithImage(VMJExchange vmjExchange, int id){
		String image = (String) vmjExchange.getRequestBodyForm("image");
		EBookDisplayDisplayWithImage ebookdisplaydisplaywithimage = ebookdisplaydisplaywithimageRepository.getObject(id);
		int recordEBookDisplayDisplayWithImageId = (((EBookDisplayDisplayWithImageDecorator) savedEBookDisplayDisplayWithImage.getRecord()).getId();
		
		EBookDisplayDisplayWithImage ebookdisplaydisplaywithimage = record.createEBookDisplayDisplayWithImage(vmjExchange);
		EBookDisplayDisplayWithImage ebookdisplaydisplaywithimagedeco = EBookDisplayDisplayWithImageFactory.createEBookDisplayDisplayWithImage("SmartLibrary.displaywithimage.core.EBookImpl", id, ebookdisplaydisplaywithimage, releaseDate, description, eBookTitle, eBookAuthor, bookID, ISBN, categories, ebookaccessimpl, createdAt
		image
		);
			return ebookdisplaydisplaywithimagedeco;
	}

	// @Restriced(permission = "")
    @Route(url="call/displaywithimage/update")
    public HashMap<String, Object> updateEBookDisplayDisplayWithImage(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		
		EBookDisplayDisplayWithImage ebookdisplaydisplaywithimage = ebookdisplaydisplaywithimageRepository.getObject(id);
		ebookdisplaydisplaywithimage = createEBookDisplayDisplayWithImage(vmjExchange, id);
		
		ebookdisplaydisplaywithimageRepository.updateObject(ebookdisplaydisplaywithimage);
		ebookdisplaydisplaywithimage = ebookdisplaydisplaywithimageRepository.getObject(id);
		//to do: fix association attributes
		
		return ebookdisplaydisplaywithimage.toHashMap();
		
	}

	// @Restriced(permission = "")
    @Route(url="call/displaywithimage/detail")
    public HashMap<String, Object> getEBookDisplayDisplayWithImage(VMJExchange vmjExchange){
		return record.getEBookDisplayDisplayWithImage(vmjExchange);
	}

	// @Restriced(permission = "")
    @Route(url="call/displaywithimage/list")
    public List<HashMap<String,Object>> getAllEBookDisplayDisplayWithImage(VMJExchange vmjExchange){
		List<EBookDisplayDisplayWithImage> ebookdisplaydisplaywithimageList = ebookdisplaydisplaywithimageRepository.getAllObject("ebookdisplaydisplaywithimage_impl");
		return transformEBookDisplayDisplayWithImageListToHashMap(ebookdisplaydisplaywithimageList);
	}

    public List<HashMap<String,Object>> transformEBookDisplayDisplayWithImageListToHashMap(List<EBookDisplayDisplayWithImage> EBookDisplayDisplayWithImageList){
		List<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
        for(int i = 0; i < EBookDisplayDisplayWithImageList.size(); i++) {
            resultList.add(EBookDisplayDisplayWithImageList.get(i).toHashMap());
        }

        return resultList;
	}

	// @Restriced(permission = "")
    @Route(url="call/displaywithimage/delete")
    public List<HashMap<String,Object>> deleteEBookDisplayDisplayWithImage(VMJExchange vmjExchange){
		if (vmjExchange.getHttpMethod().equals("OPTIONS")) {
			return null;
		}
		
		String idStr = (String) vmjExchange.getRequestBodyForm("");
		int id = Integer.parseInt(idStr);
		ebookdisplaydisplaywithimageRepository.deleteObject(id);
		return getAllEBookDisplayDisplayWithImage(vmjExchange);
	}

	
}
