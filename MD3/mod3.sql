CREATE DATABASE `mod3`;

USE `mod3`;

CREATE TABLE loai_phu_kien(
lpk_id VARCHAR(5) UNIQUE PRIMARY KEY,
lpk_ten VARCHAR(50)
);

CREATE TABLE phu_kien(
pk_id VARCHAR(5) UNIQUE PRIMARY KEY,
pk_ten VARCHAR(50),
pk_anh VARCHAR(200),
pk_gia INT,
pk_so_luong INT,
pk_mo_ta VARCHAR(200),
pk_lpk_id VARCHAR(5),
FOREIGN KEY (pk_lpk_id) REFERENCES loai_phu_kien(lpk_id)
);

DROP TABLE loai_phu_kien;
DROP TABLE phu_kien;

INSERT INTO loai_phu_kien
VALUE ('BALO','BALO'),
('CH','Chuồng'),
('AO','Áo'),
('VC','Vòng cổ'),
('TP','Thực phẩm'),
('DC','Đồ chơi');

INSERT INTO phu_kien
VALUE('BL001','BALO NẮP TRONG HỌA TIẾT MÈO','https://matpetfamily.com/wp-content/uploads/2021/05/kiotviet_fcd269b4282bd1571314b27547239f79.jpg','380000','10','Siêu cute','BALO'),
('BL002','BALO KÈM VALI','https://matpetfamily.com/wp-content/uploads/2020/10/kiotviet_040a7e8d76c78ca52ad45d6b45b3151e.jpg','1894000','10','Tiện ích','BALO'),
('BL003','BALO BỌ DỪA','https://matpetfamily.com/wp-content/uploads/2020/11/kiotviet_57551458674166afbd925d1b8ff5a351.jpg','512000','10','Cứng cáp','BALO'),
('BL004','BALO FAN-DI','https://matpetfamily.com/wp-content/uploads/2020/10/kiotviet_d257c6e376df094cfb651d23d3a40ce1.jpg','1190000','10','Sịn sịn','BALO'),
('BL005','BALO DA NẮP TRONG','https://matpetfamily.com/wp-content/uploads/2020/08/kiotviet_4fbd36b63267fd4a4fabc47bcadbe4a1.jpg','520000','10','Màu hồng nam tính','BALO'),
('BL006','BALO PHI THUỀN MINIONS','https://matpetfamily.com/wp-content/uploads/2020/07/kiotviet_94bb2989f1adc9a78d879d4a53e8878c.jpg','350000','10','Đầy đủ h','BALO'),
('CH001','LỒNG TĨNH ĐIỆN','https://petstoresaigon.com/wp-content/uploads/2021/05/chuong-gap-9.jpg','490000','3','Lồng tĩnh điện được thiết kế với chiều cao và dài rộng hợp lý tùy theo kích thước của mỗi thú cưng.','CH'),
('CH002','NỆM GIƯỜNG 3D','https://petstoresaigon.com/wp-content/uploads/2021/05/nem-thu-11.jpg','350000','2','Nệm Giường 3D sẽ giúp boss tránh được các bệnh vặt. Vì thế, ổ nằm cho chó mèo sẽ là lựa chọn sáng suốt dành cho các Boss nhà mình','CH'),
('CH003','LỒNG NHỰA LẮP RÁP','https://petstoresaigon.com/wp-content/uploads/2021/05/chuong-nhua-2.jpg','1040000','3','Chuồng Nhựa Láp Ráp cho chó mèo phù hợp với tất cả các giống chó nhỏ và mèo.','CH'),
('CH004','LỒNG HÀNG KHÔNG PD58','https://matpetfamily.com/wp-content/uploads/2020/07/kiotviet_9fb08bc272be5ed1a418b7297e04e645.png','512000','4','Lồng hàng không có thể mang Boss theo trong các chuyến du lịch','CH'),
('CH005','NHÀ GỖ VÕNG CỬA VUÔNG','https://matpetfamily.com/wp-content/uploads/2020/07/kiotviet_0250e4b8d1325e22259d7122c1d6381a.jpg','778000','1','Ngôi nhà mini của Boss','CH'),
('AO001','ÁO THUN SONGUKU','https://matpetfamily.com/wp-content/uploads/2021/01/kiotviet_985cb371313ed5c3d663803355184a59.jpg','80000','6','Áo thun full size cho các Boss','AO'),
('AO002','ÁO AMBABY 4 CHÂN','https://matpetfamily.com/wp-content/uploads/2020/07/kiotviet_e9850a2f574050228375c3e7b7a22803.jpeg','120000','3','Áo Ambaby','AO'),
('AO003','QUẦN ÁO TẾT','https://matpetfamily.com/wp-content/uploads/2021/12/396b8e03c94d03135a5c.jpg','180000','21','Bộ chơi tết','AO'),
('AO004','ÁO MƯA KHỦNG LONG','https://matpetfamily.com/wp-content/uploads/2020/10/kiotviet_61bfb2ddd225cdaed18a2c04eda6541f.jpg','220000','6','Áo mưa chống nước','AO'),
('AO005','ÁO TRÁI BẮP','https://matpetfamily.com/wp-content/uploads/2020/08/kiotviet_ea30a2f8a344703943ab179adc9c5404.jpg','50000','8','Áo lót','AO'),
('VC001','VÒNG CỔ NƠ KÈM CHUÔNG','https://matpetfamily.com/wp-content/uploads/2020/10/kiotviet_d15c1f7486eebcf8a252f0e5330e6e77.jpg','60000','12','','VC'),
('VC002','VÒNG CỔ DA XỊN','https://matpetfamily.com/wp-content/uploads/2020/10/kiotviet_130914c151a217a1c711b287d810a13a.jpg','95000','21','','VC'),
('VC003','VÒNG CHỐNG LIẾM','https://matpetfamily.com/wp-content/uploads/2020/07/kiotviet_5ee225e7a0568928ae636d0f07be4f67.jpg','70000','16','','VC'),
('VC004','VÒNG CỔ KHĂN YẾM','https://matpetfamily.com/wp-content/uploads/2021/12/A3CA1B28-6728-4FE6-8EFD-F0C415DB4347.jpeg','42000','22','','VC'),
('VC005','VÒNG CỔ KHÓA HÌNH MÈO','https://matpetfamily.com/wp-content/uploads/2020/10/kiotviet_036e4b2d9f32cd34dcef91cd668663e3.jpg','28000','18','','VC'),
('TP001','BIO MILK','https://matpetfamily.com/wp-content/uploads/2021/03/kiotviet_203cfaa6116235ce080d0b4d1c6ae078.jpeg','50000','8','Sữa cao cấp chuyên dùng cho chó mèo','TP'),
('TP002','PATE CIAO','https://matpetfamily.com/wp-content/uploads/2020/02/kiotviet_f37f4fc0f042435d9a1d7f682983b7a9.jpeg','20000','30','Pate siêu ngon, có đầy đủ vị cho các Boss','TP'),
('TP003','GANADOR ADULT','https://matpetfamily.com/wp-content/uploads/2020/10/kiotviet_b8954919c7bfc7abe0a421075a18e04b.jpeg','35000','20','Thực phẩm dinh dưỡng - 400G','TP'),
('TP004','CỎ MÈO ỐNG','https://matpetfamily.com/wp-content/uploads/2021/03/kiotviet_20f03974a01821d1e590678b7050a7f4.jpg','35000','7','Đồ ăn gây nghiện','TP'),
('TP005','BÁNH YAHO','https://matpetfamily.com/wp-content/uploads/2020/12/kiotviet_d7104b5ea773579be3776ee97c1fd89d.jpg','48000','15','Bánh thưởng cho thú cưng','TP'),
('DC001','ĐỒ CHƠI THỊT NƯỚNG','https://matpetfamily.com/wp-content/uploads/2020/07/kiotviet_97dfb761e6780b39491d8eed57aab183.jpg','25000','20','Đồ chơi không phải thức ăn','DC'),
('DC002','ĐỒ CHƠI GÀ QUAY','https://matpetfamily.com/wp-content/uploads/2020/07/kiotviet_143e8d79dc475750ca03305d44d5b051.jpeg','30000','18','Gà quay rút xương','DC'),
('DC003','ĐỒ CHƠI BÓNG','https://matpetfamily.com/wp-content/uploads/2021/01/kiotviet_eee77b1a2f3509ab4834d89d0748bf71.jpeg','20000','15','Chất liệu nhựa','DC'),
('DC004','BÓNG CHUÔNG','https://matpetfamily.com/wp-content/uploads/2021/01/kiotviet_2217e2ea69aae3216f1e246c5f068731.jpg','35000','22','Bóng chuông','DC'),
('DC005','XƯƠNG MẶT CHÓ','https://matpetfamily.com/wp-content/uploads/2020/07/kiotviet_0174c47c16d0a86f378886fd4d37ca40.jpeg','22000','28','Bóng xương mặt chó','DC');

CREATE TABLE loai_pet(
lp_id VARCHAR(5) UNIQUE PRIMARY KEY,
lp_ten VARCHAR(50)
);

DROP table pet_shop;
DROP table giong_pet;

CREATE TABLE giong_pet(
gp_id VARCHAR(10) UNIQUE PRIMARY KEY,
gp_ten VARCHAR(50),
gp_mo_ta MEDIUMTEXT,
gp_lp_id VARCHAR(5),
FOREIGN KEY (gp_lp_id) REFERENCES loai_pet(lp_id)
);

-- gp_so_luong (bỏ số lượng),

CREATE TABLE pet_shop(
ps_id INT AUTO_INCREMENT PRIMARY KEY,
ps_ten VARCHAR(50),
ps_anh mediumtext,
ps_gia INT,
ps_ngay_sinh DATE,
ps_mota VARCHAR(200),
ps_trang_thai BIT,
ps_gp_id VARCHAR(10),
FOREIGN KEY (ps_gp_id) REFERENCES giong_pet(gp_id)
);

INSERT INTO pet_shop(`ps_ten`, `ps_anh`, `ps_gia`, `ps_ngay_sinh`, `ps_mota`, `ps_trang_thai`, `ps_gp_id`)
VALUE('Husky đen','https://matpetfamily.com/wp-content/uploads/2021/02/140575124_1882521691895906_2911909454894282558_o.jpg','13000000','2021/03/12','Đẹp',1,'HUSKY'),
('Husky nâu đỏ','https://matpetfamily.com/wp-content/uploads/2019/12/72835561_1437995923015154_7605397220103290880_n.jpg','15000000','2021/06/02','Đẹp',1,'HUSKY'),
('Husky ngáo ngơ','https://matpetfamily.com/wp-content/uploads/2020/03/5.3b.jpg','10000000','2021/05/21','Đẹp',1,'HUSKY'),
('Husky mắt hai màu','https://matpetfamily.com/wp-content/uploads/2020/12/130244144_1851004625047613_8652446909424911367_o-1.jpg','12000000','2021/11/28','Đẹp',1,'HUSKY'),
('Husky hồng phấn','https://matpetfamily.com/wp-content/uploads/2020/12/129724210_1844740812340661_8582517711520321364_o.jpg','11000000','2021/12/12','Đẹp',1,'HUSKY'),
('Corgi ú nù siêu xinh','https://matpetfamily.com/wp-content/uploads/2022/01/271543555_2146263045521768_8862251087935126451_n.jpg','35000000','2021/12/12','Đẹp',1,'CORGI'),
('Corgi đực lông dài','https://matpetfamily.com/wp-content/uploads/2021/12/12AAFD4C-D8DD-47C4-8375-27AF542F97F2.jpeg','30000000','2021/12/12','Đẹp',1,'CORGI'),
('Corgi vàng siêu đáng yêu','https://matpetfamily.com/wp-content/uploads/2021/08/B51ACD1F-7BB7-4C26-B1EB-3E5AE97D55EE.jpeg','30000000','2021/12/12','Đẹp',1,'CORGI'),
('Corgi ú nu siêu đáng yêu','https://matpetfamily.com/wp-content/uploads/2019/12/75462468_1446520615496018_4012590135639015424_n201.jpg','25000000','2021/12/12','Đẹp',1,'CORGI'),
('Corgi quấn tai siêu xinh','https://matpetfamily.com/wp-content/uploads/2020/12/125294770_1830620010419408_604014806922630964_o-1.jpg','25000000','2021/12/12','Đẹp',1,'CORGI'),
('Golden béo ú nu','https://matpetfamily.com/wp-content/uploads/2020/04/A8D46AD5-8553-4AC0-A09B-4ADDC5218D07.jpeg','13000000','2021/12/12','Đẹp',1,'GOLDEN'),
('Golden sinh đôi cute','https://matpetfamily.com/wp-content/uploads/2020/04/7F9793A2-F45D-441C-AFAA-C11F2D918914.jpeg','18000000','2021/12/12','Đẹp',1,'GOLDEN'),
('Golden xinh yêu','https://matpetfamily.com/wp-content/uploads/2021/12/269847632_273782274746007_4016311206853535872_n.jpg','15000000','2021/12/12','Đẹp',1,'GOLDEN'),
('Golden vàng cháy','https://matpetfamily.com/wp-content/uploads/2022/01/269696588_292771092816417_7745811382241541016_n.jpg','15000000','2021/12/12','Đẹp',1,'GOLDEN'),
('Golden bạch kim ','https://matpetfamily.com/wp-content/uploads/2021/12/388568B6-17BD-47E8-8559-CAE133103BDF.jpeg','20000000','2021/12/12','Đẹp',1,'GOLDEN'),
('Beagle đực siêu xinh','https://matpetfamily.com/wp-content/uploads/2019/12/71813973_1420145338133546_8266992848507764736_n.jpg','9500000','2021/12/12','Đẹp',1,'BEAGLE'),
('Beagle săn thỏ','https://matpetfamily.com/wp-content/uploads/2019/12/a2_727x958.jpg','9500000','2021/12/12','Đẹp',1,'BEAGLE'),
('Beagle siêu sịn','https://sieupet.com/sites/default/files/beagle2.jpg','18000000','2021/12/12','Đẹp',1,'BEAGLE'),
('Beagle bé xinh','https://matpetfamily.com/wp-content/uploads/2019/12/b1_720x960.jpg','9500000','2021/12/12','Đẹp',1,'BEAGLE'),
('Poodle vàng mơ','https://matpetfamily.com/wp-content/uploads/2019/12/53325241_1253249824823099_4624950999151280128_n_720x960.jpg','10000000','2021/12/12','Đẹp',1,'POODLE'),
('Poodle vàng mơ xinh xinh','https://matpetfamily.com/wp-content/uploads/2019/12/71760386_1415090075305739_3323543043373531136_n.jpg','8500000','2021/12/12','Đẹp',1,'POODLE'),
('Poodle xám cute','https://matpetfamily.com/wp-content/uploads/2021/12/266347677_600611444333639_903611932124438194_n.jpg','20000000','2021/12/12','Đẹp',1,'POODLE'),
('Poodle trắng lông xù','https://matpetfamily.com/wp-content/uploads/2020/09/119211666_1772104086271001_2043173142450946394_o.jpg','12000000','2021/12/12','Đẹp',1,'POODLE'),
('Poodle nâu ù nu','https://matpetfamily.com/wp-content/uploads/2022/01/269634380_617891129423529_6480680869836863609_n.jpg','15000000','2021/12/12','Đẹp',1,'POODLE'),
('Pug siêu cute','https://matpetfamily.com/wp-content/uploads/2020/08/116791757_1725293660952044_1108601392815779091_o.jpg','9800000','2021/12/12','Đẹp',1,'PUG'),
('Pug béo ú nu','https://matpetfamily.com/wp-content/uploads/2019/12/60634147_1302412309906850_288819598420082688_n.jpg','8800000','2021/12/12','Đẹp',1,'PUG'),
('Pug đực','https://matpetfamily.com/wp-content/uploads/2021/12/557259CB-8400-421C-864B-63321D3B65B8.jpeg','15000000','2021/12/12','Đẹp',1,'PUG'),
('Samoyed siêu cute','https://matpetfamily.com/wp-content/uploads/2021/02/154711553_1906562179491857_5104632868418091991_o.jpg','12000000','2021/12/12','Đẹp',1,'SAMOYED'),
('Samoyed siêu yêu','https://matpetfamily.com/wp-content/uploads/2020/09/119938206_1778786142269462_8175390836072092712_o.jpg','13000000','2021/12/12','Đẹp',1,'SAMOYED'),
('Samoyed trắng','https://matpetfamily.com/wp-content/uploads/2021/08/E108C762-8859-4BFC-A960-158AA0244009.jpeg','12500000','2021/12/12','Đẹp',1,'SAMOYED'),
('Samoyed gấu bông','https://matpetfamily.com/wp-content/uploads/2021/11/261847321_2115882895226450_5717874721804664258_n.jpg','15000000','2021/12/12','Đẹp',1,'SAMOYED'),
('Samoyed bạch tuyết','https://matpetfamily.com/wp-content/uploads/2020/02/26.2b.jpg','12000000','2021/12/12','Đẹp',1,'SAMOYED'),
('British Đàn mèo anh lông ngắn','https://matpetfamily.com/wp-content/uploads/2020/05/96412481_1628147887333289_7452454675938279424_o.jpg','15000000','2021/12/12','Đẹp',1,'BRITISH'),
('British Mèo anh lông ngắn','https://matpetfamily.com/wp-content/uploads/2021/08/41B229EC-90FF-40E2-9C2A-DDA7B3060CA5.jpeg','14000000','2021/12/12','Đẹp',1,'BRITISH'),
('Mèo chân ngắn tai cụp','https://matpetfamily.com/wp-content/uploads/2021/11/A7B34F15-550A-4A0F-ACF5-7C7440F04FD1.jpeg','30000000','2021/12/12','Đẹp',1,'MUNCHKIN'),
('Mèo tai cụp xinh xinh','https://matpetfamily.com/wp-content/uploads/2020/02/b1.jpg','18000000','2021/12/12','Đẹp',1,'MUNCHKIN'),
('Mèo Munchkin xám cute','https://matpetfamily.com/wp-content/uploads/2020/12/129815790_1845524822262260_1393144393556835176_o.jpg','28000000','2021/12/12','Đẹp',1,'MUNCHKIN');

INSERT INTO loai_pet
VALUE('DOG','Chó'),
('CAT','Mèo');

INSERT INTO giong_pet
VALUE('HUSKY',N'Chó Husky',N'Chó Husky là một giống chó tuyết có nguồn gốc từ Sibir, Nga.
Husky có vẻ đẹp quyến rũ, thân hình dũng mãnh, sức khỏe dẻo dai phi thường.
Là giống chó hiền lành, rất tình cảm, hay tò mò, ưa vận động, rất thích người 
và đặc biệt thân thiện với trẻ em. 
Ở Việt Nam, chó Husky rất được yêu thích và được săn đón bởi đông đảo những người yêu chó.','DOG'),
('CORGI',N'Chó CORGI',N'Chó Corgi là một giống chó nhỏ, chân ngắn nhưng 
thân dài, đuôi cụt và một đôi tai lớn.
Corgi có vẻ ngoài đáng yêu, cặp mông hình trái tim tạo nên nét quyến rũ và đã 
tạo nên cơn sốt ngắm mông Corgi.  
Là giống chó rất thông minh, biết vâng lời, có bản năng bảo vệ, rất tận tâm 
với chủ và thân thiện với trẻ em. 
Chúng rất điềm tĩnh, trung thành và đáng yêu, song rất cảnh giác trước người lạ.','DOG'),
('GOLDEN',N'Chó Golden Retriever',N'Chó Golden Retriever là một giống 
chó săn thượng hạng đến từ Scotland.
Golden có bộ lông vàng mượt khá sang trọng, khuôn mặt thường xuyên cười vui vẻ, 
tuy nhiên, lúc buồn lại tỏ vẻ đáng thương rõ ràng.
Là giống chó rất thông minh, dễ huấn luyện, luôn biết cách làm hài lòng chủ nhân 
và thích vui chơi cùng mọi người.
Golden rất điềm tĩnh, hiền lành và tình cảm, lại rất nhanh nhẹn và năng động.','DOG'),
('BEAGLE',N'Chó Beagle',N'Thuộc vào loài chó săn thỏ cỡ nhỏ, Beagle là giống chó 
được rất nhiều người yêu thích và lựa chọn để nuôi. Beagle là loài chó rất đáng 
yêu và còn thân thiện với mọi người, chúng có thể trông nhà và cũng có thể chơi 
đùa với trẻ em mà không gây nguy hiểm như những loài chó họ bull. Bạn hoàn toàn 
có thể yên tâm khi lựa chọn chó Beagle làm người bạn cùng đồng hành. ','DOG'),
('POODLE',N'Chó Poodle',N'Đặc điểm loài này là tính thông minh và linh tính. Hầu hết 
dòng chó này có lớp lông xoăn tít, êm xốp, không rụng lông khi cưng nựng nên an toàn 
cho những ai bị dị ứng. Màu sắc lông đa dạng gồm: nâu đỏ, kem, trắng, đen, sôcôla, 
xám, .... Màu da theo quy định sắc tố màu lông như lông màu trắng thì da sẽ có màu 
bạc chẳng hạn và đây là màu mà nhiều người yêu thích khi nuôi Poodle.','DOG'),
('PUG',N'Chó Pug',N'Chó Pug (hay có tên gọi khác là Bug, chó mặt xệ,...) là giống 
cảnh khuyển sở hữu vẻ ngoài ngộ nghĩnh, đáng yêu, được nhiều người yêu thích. Giống 
cảnh khuyển chân lùn mặt xệ này sở hữu bộ lông siêu ngắn, mềm mượt và ôm sát cơ thể. 
Lông chúng rụng quanh năm, do đó không đòi hỏi bạn phải cắt tỉa, chăm sóc thường 
xuyên. Việc chọn nuôi bé cún Pug sẽ tạo nhiều điều kiện thuận lợi với những ai có công 
việc bận rộn, ít có thời gian tắm cho cún cưng.','DOG'),
('SAMOYED',N'Chó Samoyed',N'Chó Samoyed (hay còn được gọi là chó tuyết trắng) được mọi 
người yêu thích nhờ bộ lông trắng tinh cùng với vẻ ngoài dễ thương, đáng yêu. Samoyed 
là giống chó rất thông minh, tinh tế. Chúng có khả năng thấu hiểu được cảm xúc của con 
người thông qua nét mặt, cử chỉ hành động.','DOG'),
('BRITISH',N'Mèo Anh (Ngắn + Dài)',N'Là một giống mèo cảnh có nguồn gốc từ Anh.
Chúng sở hữu một thân hình vô cùng mập mạp đáng yêu, nổi bật với khuôn mặt tròn 
và bộ lông màu xám xanh cổ điển và một cái đuôi to.
Tính cách của chúng tuy khá lười biếng tuy nhiên lại phù hợp với những người bận 
rộn không có quá nhiều thời gian và không đòi hỏi chủ nhân của chúng phải chải 
chuốt vệ sinh thường xuyên.','CAT'),
('MUNCHKIN', N'Mèo chân ngắn',N'Những chú mèo Munchkin nổi tiếng với những chiếc chân 
ngắn cũn và thường đứng khúm khúm lại với nhau. Chiều dài thân của chúng dài khoảng 
2,5 lần so với chiều cao. Chúng có dáng người tròn trịa, đôi má bầu bĩnh và đôi mắt 
tròn xoe, long lanh.
Không chỉ có một vẻ ngoài đáng yêu và ưa nhìn, những chú mèo Munchkin cũng có tính 
cách rất dễ chịu và thân thiện. Những chú mèo Munchkin rất tinh nghịch, lém lỉnh và 
vui tươi như vẻ ngoài của chúng. Tuy nhiên, chúng cũng rất ngọt ngào, đặc biệt 
là rất quấn chủ.
','CAT');

CREATE TABLE dich_vu(
dv_id VARCHAR(10) UNIQUE PRIMARY KEY,
dv_ten VARCHAR(100)
);

create table chi_tiet_dv(
ctdv_id varchar(10) unique primary key,
ctdv_anh mediumtext,
ctdv_ten varchar(100) not null,
ctdv_gia int,
ctdv_mo_ta mediumtext,
ctdv_trang_thai bit,
ctdv_dv_id varchar(5) not null,
foreign key (ctdv_dv_id) references dich_vu(dv_id)
);

DROP TABLE dich_vu;
DROP TABLE chi_tiet_dv;

INSERT INTO dich_vu
VALUE('SPA','Spa'),
('HT','Hotel'),
('TC','Tiêm chủng');

INSERT INTO chi_tiet_dv
VALUE
('SP001','https://matpetfamily.com/wp-content/uploads/2020/06/kiotviet_abd62632321f9035cc7bca7e05e0ca1e.jpg','Vệ sinh tai mắt','30000','',1,'SPA'),
('SP001','https://matpetfamily.com/wp-content/uploads/2020/06/kiotviet_abd62632321f9035cc7bca7e05e0ca1e.jpg','Cắt móng + dũa móng','30000','',1,'SPA'),
('SP001','https://matpetfamily.com/wp-content/uploads/2020/06/kiotviet_abd62632321f9035cc7bca7e05e0ca1e.jpg','Tắm spa','200000','',1,'SPA'),
('SP001','https://matpetfamily.com/wp-content/uploads/2020/06/kiotviet_abd62632321f9035cc7bca7e05e0ca1e.jpg','Cắt tỉa tạo kiểu','400000','',1,'SPA'),
('SP001','https://matpetfamily.com/wp-content/uploads/2020/06/kiotviet_abd62632321f9035cc7bca7e05e0ca1e.jpg','Cạo lông','220000','',1,'SPA'),
('HT001','https://matpetfamily.com/wp-content/uploads/2020/06/kiotviet_abd62632321f9035cc7bca7e05e0ca1e.jpg','Hotel cao cấp','200000','Kèm spa',1,'HT'),
('HT002','https://matpetfamily.com/wp-content/uploads/2020/06/kiotviet_abd62632321f9035cc7bca7e05e0ca1e.jpg','Hotel thường','150000','Không dịch vụ',1,'HT'),
('TC001','https://matpetfamily.com/wp-content/uploads/2020/06/kiotviet_abd62632321f9035cc7bca7e05e0ca1e.jpg','Vaccin phòng bệnh dại','300000','Chích định kỳ 1 năm 1 lần',1,'TC'),
('TC002','https://matpetfamily.com/wp-content/uploads/2020/06/kiotviet_abd62632321f9035cc7bca7e05e0ca1e.jpg','Vaccin phòng bệnh leuco','300000','Chích định kỳ 1 năm 1 lần',1,'TC'),
('TC003','https://matpetfamily.com/wp-content/uploads/2020/06/kiotviet_abd62632321f9035cc7bca7e05e0ca1e.jpg','Vaccin phòng bệnh lepto','300000','Chích định kỳ 1 năm 1 lần',1,'TC');