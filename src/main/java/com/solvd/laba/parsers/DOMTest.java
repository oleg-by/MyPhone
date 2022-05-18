package com.solvd.laba.parsers;

import com.solvd.laba.enums.AccountType;
import com.solvd.laba.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMTest {

    private static final Logger LOGGER = LogManager.getLogger(DOMTest.class);
    private static final String CUSTOMER = "customer";
    private static final String USER = "user";
    private static final String ADDRESS = "address";
    private static final String PRODUCT = "product";
    private static final String ORDER = "order";

    private static List<User> userList = new ArrayList<>();
    private static List<Customer> customerList = new ArrayList<>();
    private static List<Address> addressList = new ArrayList<>();
    private static List<Product> productList = new ArrayList<>();
    private static List<Order> orderList = new ArrayList<>();

    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = documentBuilderFactory.newDocumentBuilder();
            doc = builder.parse(new File(System.getProperty("user.dir") + "/src/main/resources/msXML_input.xml"));
        } catch (ParserConfigurationException e) {
            LOGGER.error(e.getMessage());
        } catch (SAXException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        collectData(doc, CUSTOMER);
        collectData(doc, USER);
        collectData(doc, ADDRESS);
        collectData(doc, PRODUCT);
        collectData(doc, ORDER);
        LOGGER.info(customerList);
        LOGGER.info(userList);
        LOGGER.info(addressList);
        LOGGER.info(productList);
        LOGGER.info(orderList);
    }

    private static void collectData(Document document, final String tagname) {
        NodeList nodeList = null;
        if (document != null) {
            nodeList = document.getElementsByTagName(tagname);
        }
        int length = 0;
        if (nodeList != null) {
            length = nodeList.getLength();
        }
        for (int i = 0; i < length; i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            NamedNodeMap attributes = node.getAttributes();
            switch (tagname) {
                case CUSTOMER: {
                    Customer customer = new Customer();
                    customer.setId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    customer.setIdUser(Integer.parseInt(attributes.getNamedItem("idUser").getNodeValue()));
                    customer.setIdAddressC(Integer.parseInt(attributes.getNamedItem("idAddressC").getNodeValue()));
                    customer.setFirstName(element.getElementsByTagName("firstName").item(0).getTextContent());
                    customer.setLastName(element.getElementsByTagName("lastName").item(0).getTextContent());
                    customer.setPhoneNumber(Long.parseLong(element.getElementsByTagName("phoneNumber").item(0).getTextContent()));
                    customerList.add(customer);
                }
                break;
                case USER: {
                    User user = new User();
                    user.setId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    user.setUsername(element.getElementsByTagName("username").item(0).getTextContent());
                    user.setEmail(element.getElementsByTagName("email").item(0).getTextContent());
                    user.setPassword(element.getElementsByTagName("password").item(0).getTextContent());
                    user.setCreateTime(element.getElementsByTagName("createTime").item(0).getTextContent());
                    user.setAccountType(AccountType.valueOf(attributes.getNamedItem("accountType").getNodeValue().toUpperCase()));
                    user.setBirth(element.getElementsByTagName("birth").item(0).getTextContent());
                    userList.add(user);
                }
                break;
                case ADDRESS: {
                    Address address = new Address();
                    address.setId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    address.setCountry(element.getElementsByTagName("country").item(0).getTextContent());
                    address.setCity(element.getElementsByTagName("city").item(0).getTextContent());
                    address.setStreet(element.getElementsByTagName("street").item(0).getTextContent());
                    address.setBuildingNumber(Integer.parseInt(element.getElementsByTagName("buildingNumber").item(0).getTextContent()));
                    address.setCorp(Integer.parseInt(element.getElementsByTagName("corp").item(0).getTextContent()));
                    address.setApt(Integer.parseInt(element.getElementsByTagName("apt").item(0).getTextContent()));
                    address.setFloor(Integer.parseInt(element.getElementsByTagName("floor").item(0).getTextContent()));
                    addressList.add(address);
                }
                break;
                case PRODUCT: {
                    Product product = new Product();
                    product.setId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    product.setIdCategory(Integer.parseInt(attributes.getNamedItem("idCategory").getNodeValue()));
                    product.setIdDescription(Integer.parseInt(attributes.getNamedItem("idDescription").getNodeValue()));
                    product.setName(element.getElementsByTagName("name").item(0).getTextContent());
                    product.setPrice(Float.parseFloat(element.getElementsByTagName("price").item(0).getTextContent()));
                    productList.add(product);
                }
                break;
                case ORDER: {
                    Order order = new Order();
                    order.setId(Integer.parseInt(attributes.getNamedItem("id").getNodeValue()));
                    order.setIdCustomer(Integer.parseInt(attributes.getNamedItem("idCustomer").getNodeValue()));
                    order.setIdDelivery(Integer.parseInt(attributes.getNamedItem("idDelivery").getNodeValue()));
                    order.setIdPayment(Integer.parseInt(attributes.getNamedItem("idPayment").getNodeValue()));
                    order.setIdProduct(Integer.parseInt(element.getElementsByTagName("idProduct").item(0).getTextContent()));
                    order.setCount(Integer.parseInt(element.getElementsByTagName("count").item(0).getTextContent()));
                    order.setUnitPrice(Float.parseFloat(element.getElementsByTagName("unitPrice").item(0).getTextContent()));
                    orderList.add(order);
                }
                break;
            }
        }
    }

}
