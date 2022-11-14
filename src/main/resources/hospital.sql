select id, hospital_name,road_name_address,business_type_name
from nation_wide_hospitals where hospital_name like '%피부과%' and road_name_address like "경기도 수원시%";

select business_type_name, hospital_name, road_name_address
from nation_wide_hospitals
where business_type_name in ('보건소','보건진료소','보건지소');