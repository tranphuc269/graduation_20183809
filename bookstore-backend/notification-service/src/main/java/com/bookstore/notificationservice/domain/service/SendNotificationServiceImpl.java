package com.bookstore.notificationservice.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Arrays;


@Service
public class SendNotificationServiceImpl implements ISendNotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendGmail() {
        String subject = "Thư xác nhận đơn hàng của hệ thống";
        String content = "<tbody><tr>\n" +
                "      <td valign=\"top\" style=\"padding:0;Margin:0\">\n" +
                "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-header\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
                "         <tbody><tr>\n" +
                "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "           <table bgcolor=\"#ffffff\" class=\"es-header-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FEF3E1;width:600px\">\n" +
                "             <tbody><tr>\n" +
                "              <td align=\"left\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-bottom:30px;padding-top:40px\">\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td class=\"es-m-p0r\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:14px\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/group_93.png\" alt=\"Logo\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" height=\"35\" title=\"Logo\"></a></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table></td>\n" +
                "             </tr>\n" +
                "           </tbody></table></td>\n" +
                "         </tr>\n" +
                "       </tbody></table>\n" +
                "       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                "         <tbody><tr>\n" +
                "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#ffffff;width:600px\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\">\n" +
                "             <tbody><tr>\n" +
                "              <td align=\"left\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:323px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellspacing=\"0\" cellpadding=\"0\" align=\"left\" class=\"es-left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td class=\"es-m-p0r es-m-p20b\" valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:323px\">\n" +
                "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:5px;font-size:0px\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:16px\"><img class=\"adapt-img\" src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/illustration_QF7.png\" alt=\"startup\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"323\" title=\"startup\"></a></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:217px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"left\" style=\"padding:0;Margin:0;width:217px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:15px;padding-top:40px\"><h1 style=\"Margin:0;line-height:58px;mso-line-height-rule:exactly;font-family:Oswald, sans-serif;font-size:48px;font-style:normal;font-weight:bold;color:#363E44\">Cảm ơn bạn!</h1></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:15px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#363E44;font-size:16px\">Bạn đã đặt hàng thành công, đơn hàng của bạn sẽ được gửi đi sớm nhất</p></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:21px;color:#363E44;font-size:14px\">Chia sẻ với bạn bè :</p></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0\">\n" +
                "                       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-table-not-adapt es-social\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                         <tbody><tr>\n" +
                "                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;padding-right:10px\"><a target=\"_blank\" href=\"https://www.facebook.com/sharer/sharer.php\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:16px\"><img title=\"Facebook\" src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/logo-black/facebook-logo-black.png\" alt=\"Fb\" height=\"24\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
                "                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;padding-right:10px\"><a target=\"_blank\" href=\"https://twitter.com/intent/tweet\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:16px\"><img title=\"Twitter\" src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/logo-black/twitter-logo-black.png\" alt=\"Tw\" height=\"24\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
                "                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;padding-right:10px\"><a target=\"_blank\" href=\"https://www.linkedin.com/sharing/share-offsite/\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:16px\"><img title=\"Linkedin\" src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/logo-black/linkedin-logo-black.png\" alt=\"In\" height=\"24\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
                "                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0\"><a target=\"_blank\" href=\"https://pinterest.com/pin/create/button/?media=https%3A%2F%2Foioftq.stripocdn.email%2Fcontent%2Fassets%2Fimg%2Fsocial-icons%2Flogo-black%2Fpinterest-logo-black.png\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:16px\"><img title=\"Pinterest\" src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/logo-black/pinterest-logo-black.png\" alt=\"P\" height=\"24\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
                "                         </tr>\n" +
                "                       </tbody></table></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><h2 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:Oswald, sans-serif;font-size:30px;font-style:normal;font-weight:bold;color:#363E44\">Các bước đặt hàng</h2></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-top:30px\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:50px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td class=\"es-m-p20b\" align=\"left\" style=\"padding:0;Margin:0;width:50px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:16px\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/number1.png\" alt=\"\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"50\"></a></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:490px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"left\" style=\"padding:0;Margin:0;width:490px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#363E44;font-size:16px\">Sau khi đặt hàng trên hệ thống, nhân viên sẽ liên lạc lại với bạn trong thời gian ngắn nhất để xác nhận đơn hàng.</p></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-top:30px\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:50px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td class=\"es-m-p20b\" align=\"left\" style=\"padding:0;Margin:0;width:50px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:16px\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/number2.png\" alt=\"\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"50\"></a></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:490px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"left\" style=\"padding:0;Margin:0;width:490px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#363E44;font-size:16px\">Trước khi nhận hàng, hãy kiểm tra hàng thật kỹ nhé \uD83D\uDE0A</p></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td align=\"left\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:40px\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:50px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td class=\"es-m-p20b\" align=\"left\" style=\"padding:0;Margin:0;width:50px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:16px\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/numbre3.png\" alt=\"\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"50\"></a></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:490px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"left\" style=\"padding:0;Margin:0;width:490px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#363E44;font-size:16px\">Chúng tôi rất hân hạnh được phục vụ bạn.</p></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td align=\"left\" bgcolor=\"#fef3e1\" style=\"Margin:0;padding-bottom:20px;padding-left:20px;padding-right:20px;padding-top:30px;background-color:#fef3e1\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td class=\"es-m-p20b\" align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;border-width:1px;border-style:solid;border-color:#333333;border-radius:15px;background-color:#ffffff\" bgcolor=\"#ffffff\" role=\"presentation\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:16px\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/bwink_ppl_15_single_12_1.png\" alt=\"\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"220\"></a></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" class=\"es-m-txt-l\" style=\"padding:0;Margin:0;padding-bottom:5px\"><h2 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:Oswald, sans-serif;font-size:30px;font-style:normal;font-weight:bold;color:#363E44\">Children's cooking school</h2></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td style=\"padding:0;Margin:0\">\n" +
                "                       <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"es-menu\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                         <tbody><tr class=\"links-images-left\">\n" +
                "                          <td align=\"left\" valign=\"top\" width=\"50%\" id=\"esd-menu-id-0\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px;padding-right:10px;border:0\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;display:block;font-family:arial, 'helvetica neue', helvetica, sans-serif;color:#363E44;font-size:12px\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/group_83.png\" alt=\"Myron Rogers\" title=\"Myron Rogers\" align=\"absmiddle\" height=\"32\" style=\"display:inline-block !important;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;padding-right:5px;vertical-align:middle\">Myron Rogers</a></td>\n" +
                "                          <td align=\"left\" valign=\"top\" width=\"50%\" id=\"esd-menu-id-1\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px;border:0\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;display:block;font-family:arial, 'helvetica neue', helvetica, sans-serif;color:#363E44;font-size:12px\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/group_92_QKr.png\" alt=\"London\" title=\"London\" align=\"absmiddle\" height=\"32\" style=\"display:inline-block !important;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;padding-right:5px;vertical-align:middle\">London</a></td>\n" +
                "                         </tr>\n" +
                "                       </tbody></table></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#363E44;font-size:16px\">Tristique risus nec feugiat in. Facilisis magna etiam tempor orci eu lobortis elementum nibh tellus. Ac felis donec et odio.</p></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td align=\"left\" bgcolor=\"#fef3e1\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;background-color:#fef3e1\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td class=\"es-m-p20b\" align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" class=\"es-m-txt-c\" style=\"Margin:0;padding-top:5px;padding-bottom:10px;padding-left:10px;padding-right:10px\"><h3 style=\"Margin:0;line-height:26px;mso-line-height-rule:exactly;font-family:Oswald, sans-serif;font-size:22px;font-style:normal;font-weight:bold;color:#363E44\">$8&nbsp;000/$20 000</h3></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"right\" class=\"es-m-txt-c\" style=\"Margin:0;padding-top:5px;padding-bottom:10px;padding-left:10px;padding-right:10px\"><h3 style=\"Margin:0;line-height:26px;mso-line-height-rule:exactly;font-family:Oswald, sans-serif;font-size:22px;font-style:normal;font-weight:bold;color:#363E44\">35 day left</h3></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td align=\"left\" bgcolor=\"#fef3e1\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-bottom:30px;background-color:#fef3e1\">\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><img class=\"adapt-img\" src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/group_94.png\" alt=\"\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" height=\"15\"></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td align=\"left\" class=\"es-m-txt-c\" style=\"Margin:0;padding-bottom:5px;padding-top:10px;padding-left:10px;padding-right:10px\"><h3 style=\"Margin:0;line-height:26px;mso-line-height-rule:exactly;font-family:Oswald, sans-serif;font-size:22px;font-style:normal;font-weight:bold;color:#363E44\">33% funded</h3></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table></td>\n" +
                "             </tr>\n" +
                "           </tbody></table></td>\n" +
                "         </tr>\n" +
                "       </tbody></table>\n" +
                "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                "         <tbody><tr>\n" +
                "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
                "             <tbody><tr>\n" +
                "              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-top:30px\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td class=\"es-m-p20b\" align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;border-left:1px solid #333333;border-right:1px solid #333333;border-top:1px solid #333333;border-bottom:1px solid #333333;border-radius:15px\" role=\"presentation\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:15px;Margin:0\"><h2 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:Oswald, sans-serif;font-size:30px;font-style:normal;font-weight:bold;color:#363E44\">CHI TIẾT ĐƠN HÀNG</h2></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "                 <tbody><tr class=\"es-mobile-hidden\">\n" +
                "                  <td align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"center\" height=\"40\" style=\"padding:0;Margin:0\"></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:250px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" align=\"left\" class=\"es-left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td class=\"es-m-p20b\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:250px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><h3 style=\"Margin:0;line-height:26px;mso-line-height-rule:exactly;font-family:Oswald, sans-serif;font-size:22px;font-style:normal;font-weight:bold;color:#363E44\">Hoá đơn</h3></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:290px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:290px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;border-left:1px solid #666666\" role=\"presentation\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0;padding-left:10px;padding-right:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#363E44;font-size:16px\">Giá trị đơn hàng : 30,000 VNĐ<br>Số lượng sản phẩm : 6<br>Phí giao hàng : 10,000</p></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-top:30px\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:250px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" align=\"left\" class=\"es-left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td class=\"es-m-p20b\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:250px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><h3 style=\"Margin:0;line-height:26px;mso-line-height-rule:exactly;font-family:Oswald, sans-serif;font-size:22px;font-style:normal;font-weight:bold;color:#363E44\">Reward</h3></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:290px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:290px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;border-left:1px solid #666666\" role=\"presentation\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0;padding-left:10px;padding-right:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#363E44;font-size:16px\">Nunc aliquet bibendums:</p>\n" +
                "                       <ul>\n" +
                "                        <li style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;Margin-bottom:15px;margin-left:0;color:#363E44;font-size:16px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#363E44;font-size:16px\">Accumsan sit amet nulla facilisi morbi tempus iaculi.</p></li>\n" +
                "                        <li style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;Margin-bottom:15px;margin-left:0;color:#363E44;font-size:16px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#363E44;font-size:16px\">Sagittis eu volutpat odio facilisis mauris sit amet.</p></li>\n" +
                "                        <li style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;Margin-bottom:15px;margin-left:0;color:#363E44;font-size:16px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#363E44;font-size:16px\">Consectetur libero id faucibus nisl tincidunt eget.</p></li>\n" +
                "                       </ul></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-top:30px\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:250px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" align=\"left\" class=\"es-left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td class=\"es-m-p20b\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:250px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><h3 style=\"Margin:0;line-height:26px;mso-line-height-rule:exactly;font-family:Oswald, sans-serif;font-size:22px;font-style:normal;font-weight:bold;color:#363E44\">Dự báo</h3></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:290px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:290px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;border-left:1px solid #666666\" role=\"presentation\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0;padding-left:10px;padding-right:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#363E44;font-size:16px\">Đơn hàng của bạn sẽ được gửi trước ngày 3/5/2023</p></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td align=\"left\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:250px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" align=\"left\" class=\"es-left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td class=\"es-m-p20b\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:250px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><h3 style=\"Margin:0;line-height:26px;mso-line-height-rule:exactly;font-family:Oswald, sans-serif;font-size:22px;font-style:normal;font-weight:bold;color:#363E44\">Backer</h3></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:290px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:290px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;border-left:1px solid #666666\" role=\"presentation\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0;padding-left:10px;padding-right:10px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#363E44;font-size:16px\">31</p></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
                "             </tr>\n" +
                "           </tbody></table></td>\n" +
                "         </tr>\n" +
                "       </tbody></table>\n" +
                "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
                "         <tbody><tr>\n" +
                "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "           <table bgcolor=\"#fef3e1\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#fef3e1;width:600px\">\n" +
                "             <tbody><tr>\n" +
                "              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-top:30px\">\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0;padding-bottom:5px\"><h2 style=\"Margin:0;line-height:36px;mso-line-height-rule:exactly;font-family:Oswald, sans-serif;font-size:30px;font-style:normal;font-weight:bold;color:#363E44\">Discover more new interesting projects</h2></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td align=\"left\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;border-width:1px;border-style:solid;border-color:#333333;border-radius:15px;background-color:#ffffff\" bgcolor=\"#ffffff\" role=\"presentation\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:16px\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/bwink_ppl_15_single_05.png\" alt=\"\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"220\"></a></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "                 <tr>\n" +
                "                  <td align=\"left\" class=\"es-m-p20b\" style=\"padding:0;Margin:0;width:270px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0;padding-top:5px;padding-bottom:5px\"><h3 style=\"Margin:0;line-height:26px;mso-line-height-rule:exactly;font-family:Oswald, sans-serif;font-size:22px;font-style:normal;font-weight:bold;color:#363E44\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:22px\">Online karaoke</a></h3></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td align=\"center\" class=\"es-m-txt-l\" style=\"padding:0;Margin:0;padding-top:5px;font-size:0px\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:16px\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/group_944.png\" alt=\"\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" height=\"9\" width=\"270\"></a></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td style=\"padding:0;Margin:0\">\n" +
                "                       <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"es-menu\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                         <tbody><tr class=\"links-images-left\">\n" +
                "                          <td align=\"left\" valign=\"top\" width=\"100%\" id=\"esd-menu-id-0\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px;padding-right:10px;border:0\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;display:block;font-family:arial, 'helvetica neue', helvetica, sans-serif;color:#363E44;font-size:12px\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/group_83.png\" alt=\"by Myron Rogers\" title=\"by Myron Rogers\" align=\"absmiddle\" height=\"25\" style=\"display:inline-block !important;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;padding-right:5px;vertical-align:middle\">by Myron Rogers</a></td>\n" +
                "                         </tr>\n" +
                "                       </tbody></table></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#363E44;font-size:16px\">Tristique risus nec feugiat in. Facilisis magna etiam tempor orci eu lobortis elementum nibh tellus.</p></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:270px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:separate;border-spacing:0px;border-width:1px;border-style:solid;border-color:#333333;border-radius:15px;background-color:#ffffff\" bgcolor=\"#ffffff\" role=\"presentation\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:16px\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/bwink_ppl_16_single_12.png\" alt=\"\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"220\"></a></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "                 <tr>\n" +
                "                  <td align=\"left\" style=\"padding:0;Margin:0;width:270px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0;padding-top:5px;padding-bottom:5px\"><h3 style=\"Margin:0;line-height:26px;mso-line-height-rule:exactly;font-family:Oswald, sans-serif;font-size:22px;font-style:normal;font-weight:bold;color:#363E44\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:22px\">Nursing home</a></h3></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td align=\"center\" class=\"es-m-txt-l\" style=\"padding:0;Margin:0;padding-top:5px;font-size:0px\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:16px\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/group_94_dfZ.png\" alt=\"\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"270\"></a></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td style=\"padding:0;Margin:0\">\n" +
                "                       <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"es-menu\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                         <tbody><tr class=\"links-images-left\">\n" +
                "                          <td align=\"left\" valign=\"top\" width=\"100%\" id=\"esd-menu-id-0\" style=\"padding:0;Margin:0;padding-top:10px;padding-bottom:10px;padding-right:10px;border:0\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;display:block;font-family:arial, 'helvetica neue', helvetica, sans-serif;color:#363E44;font-size:12px\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/mask_group.png\" alt=\"by Lorin Dorsey\" title=\"by Lorin Dorsey\" align=\"absmiddle\" height=\"25\" style=\"display:inline-block !important;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;padding-right:5px;vertical-align:middle\">by Lorin Dorsey</a></td>\n" +
                "                         </tr>\n" +
                "                       </tbody></table></td>\n" +
                "                     </tr>\n" +
                "                     <tr>\n" +
                "                      <td align=\"left\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:24px;color:#363E44;font-size:16px\">Eu non diam phasellus vestibulum lorem sed risus ultricies tristique. Neque vitae tempus quam.</p></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-bottom:30px\">\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0\"><span class=\"es-button-border\" style=\"border-style:solid;border-color:#2CB543;background:#D87355;border-width:0px;display:inline-block;border-radius:30px;width:auto\"><a href=\"https://viewstripo.email\" class=\"es-button\" target=\"_blank\" style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;color:#FFFFFF;font-size:18px;border-style:solid;border-color:#D87355;border-width:10px 30px 10px 30px;display:inline-block;background:#D87355;border-radius:30px;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-weight:normal;font-style:normal;line-height:22px;width:auto;text-align:center\">Chi tiết đơn hàng</a></span></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table></td>\n" +
                "             </tr>\n" +
                "           </tbody></table></td>\n" +
                "         </tr>\n" +
                "       </tbody></table>\n" +
                "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
                "         <tbody><tr>\n" +
                "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "           <table class=\"es-footer-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\">\n" +
                "             <tbody><tr>\n" +
                "              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-top:30px\"><!--[if mso]><table style=\"width:560px\" cellpadding=\"0\" cellspacing=\"0\"><tr><td style=\"width:150px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" align=\"left\" class=\"es-left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td class=\"es-m-p20b\" align=\"left\" style=\"padding:0;Margin:0;width:130px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-top:5px;font-size:0px\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#363E44;font-size:12px\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_1387c20ae75f81603b964b62ceac1548/images/group_93.png\" alt=\"Logo\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" title=\"Logo\" height=\"30\"></a></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                  <td class=\"es-hidden\" style=\"padding:0;Margin:0;width:20px\"></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td><td style=\"width:260px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-left\" align=\"left\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:left\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"left\" class=\"es-m-p20b\" style=\"padding:0;Margin:0;width:260px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td style=\"padding:0;Margin:0\">\n" +
                "                       <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"es-menu\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                         <tbody><tr class=\"links\">\n" +
                "                          <td align=\"center\" valign=\"top\" width=\"33.33%\" style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:15px;padding-bottom:5px;border:0\" id=\"esd-menu-id-0\"><a target=\"_blank\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;display:block;font-family:arial, 'helvetica neue', helvetica, sans-serif;color:#363E44;font-size:12px\">Visit Us </a></td>\n" +
                "                          <td align=\"center\" valign=\"top\" width=\"33.33%\" style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:15px;padding-bottom:5px;border:0\" id=\"esd-menu-id-1\"><a target=\"_blank\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;display:block;font-family:arial, 'helvetica neue', helvetica, sans-serif;color:#363E44;font-size:12px\">Privacy Policy</a></td>\n" +
                "                          <td align=\"center\" valign=\"top\" width=\"33.33%\" style=\"Margin:0;padding-left:5px;padding-right:5px;padding-top:15px;padding-bottom:5px;border:0\" id=\"esd-menu-id-2\"><a target=\"_blank\" href=\"\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;display:block;font-family:arial, 'helvetica neue', helvetica, sans-serif;color:#363E44;font-size:12px\">Terms of Use</a></td>\n" +
                "                         </tr>\n" +
                "                       </tbody></table></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td><td style=\"width:20px\"></td><td style=\"width:130px\" valign=\"top\"><![endif]-->\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-right\" align=\"right\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;float:right\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"left\" style=\"padding:0;Margin:0;width:130px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"right\" class=\"es-m-txt-c\" style=\"padding:0;Margin:0;padding-bottom:5px;padding-top:10px;font-size:0\">\n" +
                "                       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-table-not-adapt es-social\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                         <tbody><tr>\n" +
                "                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;padding-right:10px\"><img title=\"Facebook\" src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/logo-black/facebook-logo-black.png\" alt=\"Fb\" width=\"24\" height=\"24\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\n" +
                "                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;padding-right:10px\"><img title=\"Twitter\" src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/logo-black/twitter-logo-black.png\" alt=\"Tw\" width=\"24\" height=\"24\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\n" +
                "                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;padding-right:10px\"><img title=\"Instagram\" src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/logo-black/instagram-logo-black.png\" alt=\"Inst\" width=\"24\" height=\"24\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\n" +
                "                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0\"><img title=\"Youtube\" src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/logo-black/youtube-logo-black.png\" alt=\"Yt\" width=\"24\" height=\"24\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></td>\n" +
                "                         </tr>\n" +
                "                       </tbody></table></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table><!--[if mso]></td></tr></table><![endif]--></td>\n" +
                "             </tr>\n" +
                "             <tr>\n" +
                "              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-bottom:30px\">\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"center\" class=\"es-m-p20r es-m-p20l\" style=\"padding:0;Margin:0;padding-top:15px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#363E44;font-size:12px\">Start Up © 2022&nbsp;Start Up, Inc. All Rights Reserved.</p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:18px;color:#363E44;font-size:12px\">4562 Hazy Panda Limits, Chair Crossing, Kentucky, US, 607898</p></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table></td>\n" +
                "             </tr>\n" +
                "           </tbody></table></td>\n" +
                "         </tr>\n" +
                "       </tbody></table>\n" +
                "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-footer\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
                "         <tbody><tr>\n" +
                "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
                "           <table bgcolor=\"#ffffff\" class=\"es-footer-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\">\n" +
                "             <tbody><tr>\n" +
                "              <td align=\"left\" style=\"Margin:0;padding-top:20px;padding-bottom:20px;padding-left:20px;padding-right:20px\">\n" +
                "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                 <tbody><tr>\n" +
                "                  <td align=\"left\" style=\"padding:0;Margin:0;width:560px\">\n" +
                "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
                "                     <tbody><tr>\n" +
                "                      <td align=\"center\" class=\"es-infoblock made_with\" style=\"padding:0;Margin:0;line-height:120%;font-size:0;color:#CCCCCC\"><a target=\"_blank\" href=\"https://viewstripo.email/?utm_source=templates&amp;utm_medium=email&amp;utm_campaign=crowdfunding_3&amp;utm_content=thanks_for_backing\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:none;color:#CCCCCC;font-size:12px\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_09023af45624943febfa123c229a060b/images/7911561025989373.png\" alt=\"\" width=\"125\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td>\n" +
                "                     </tr>\n" +
                "                   </tbody></table></td>\n" +
                "                 </tr>\n" +
                "               </tbody></table></td>\n" +
                "             </tr>\n" +
                "           </tbody></table></td>\n" +
                "         </tr>\n" +
                "       </tbody></table></td>\n" +
                "     </tr>\n" +
                "   </tbody>>";
        sendMail("meliodasss2000@gmail.com", subject, content, false, true);

    }
    public void sendMail(String to, String subject, String content, boolean
            isMultipart, boolean isHtml){

//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        try {
//            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,
//                    isMultipart,
//                    "UTF-8");
//            messageHelper.setFrom("phuc260900@gmail.com");
//            messageHelper.setTo(to);
//            messageHelper.setSubject(subject);
//            messageHelper.setText(content, isHtml);
//            mailSender.send(mimeMessage);
//        } catch (Exception ignored) {
//            ignored.printStackTrace();
//        }
    }
    @Override
    public void sendNotificationToDevice() {

    }
}
