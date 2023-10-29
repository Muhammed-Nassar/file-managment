package com.digi.filemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FileManagementApplication {

//	private final Logger logger = LoggerFactory.getLogger(FileManagementApplication.class);
//
//	@Autowired
//	private ItemRepository itemRepository;
	public static void main(String[] args) {
		SpringApplication.run(FileManagementApplication.class, args);

	}
//
//	@EventListener(ApplicationReadyEvent.class)
//	public void runAfterStartup() {
//		queryAllCustomers();
//		createCustomer();
//		queryAllCustomers();
//	}
//
//	private void createCustomer() {
//		ItemEntity itemEntity = new ItemEntity();
//		itemEntity.setName("stc_assessment");
//		itemEntity.setType(ItemTypeEnum.SPACE);
//		logger.info("Saving new Item...");
//		this.itemRepository.save(itemEntity);
//	}
//
//	private void queryAllCustomers() {
//		List<ItemEntity> allCustomers = this.itemRepository.findAll();
//		logger.info("Number of customers: " + allCustomers.size());
//	}


}
