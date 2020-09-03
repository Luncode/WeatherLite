package com.luncode.weatherlite.model;

import java.util.List;

public class WeatherModel {

    /**
     * msg : success
     * code : 1
     * data : {"error":0,"status":"success","date":"2020-08-26","results":[{"currentCity":"成都","pm25":"77","index":[{"des":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。","tipt":"穿衣指数","title":"穿衣","zs":"炎热"},{"des":"适宜洗车，未来持续两天无雨天气较好，适合擦洗汽车，蓝天白云、风和日丽将伴您的车子连日洁净。","tipt":"洗车指数","title":"洗车","zs":"适宜"},{"des":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。","tipt":"感冒指数","title":"感冒","zs":"少发"},{"des":"天气较好，较适宜进行各种运动，但考虑气温较高且湿度较大，请适当降低运动强度，并及时补充水分。","tipt":"运动指数","title":"运动","zs":"较适宜"},{"des":"紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。","tipt":"紫外线强度指数","title":"紫外线强度","zs":"很强"}],"weather_data":[{"date":"周三 08月26日 (实时：26℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/qing.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"晴","wind":"无持续风向微风","temperature":"32 ~ 21℃"},{"date":"周四","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/qing.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"晴","wind":"无持续风向微风","temperature":"31 ~ 22℃"},{"date":"周五","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/zhenyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/zhenyu.png","weather":"阵雨","wind":"无持续风向微风","temperature":"31 ~ 22℃"},{"date":"周六","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/xiaoyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/xiaoyu.png","weather":"小雨","wind":"无持续风向微风","temperature":"29 ~ 23℃"}]}]}
     */

    private String msg;
    private int code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * error : 0
         * status : success
         * date : 2020-08-26
         * results : [{"currentCity":"成都","pm25":"77","index":[{"des":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。","tipt":"穿衣指数","title":"穿衣","zs":"炎热"},{"des":"适宜洗车，未来持续两天无雨天气较好，适合擦洗汽车，蓝天白云、风和日丽将伴您的车子连日洁净。","tipt":"洗车指数","title":"洗车","zs":"适宜"},{"des":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。","tipt":"感冒指数","title":"感冒","zs":"少发"},{"des":"天气较好，较适宜进行各种运动，但考虑气温较高且湿度较大，请适当降低运动强度，并及时补充水分。","tipt":"运动指数","title":"运动","zs":"较适宜"},{"des":"紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。","tipt":"紫外线强度指数","title":"紫外线强度","zs":"很强"}],"weather_data":[{"date":"周三 08月26日 (实时：26℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/qing.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"晴","wind":"无持续风向微风","temperature":"32 ~ 21℃"},{"date":"周四","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/qing.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"晴","wind":"无持续风向微风","temperature":"31 ~ 22℃"},{"date":"周五","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/zhenyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/zhenyu.png","weather":"阵雨","wind":"无持续风向微风","temperature":"31 ~ 22℃"},{"date":"周六","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/xiaoyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/xiaoyu.png","weather":"小雨","wind":"无持续风向微风","temperature":"29 ~ 23℃"}]}]
         */

        private int error;
        private String status;
        private String date;
        private List<ResultsBean> results;

        public int getError() {
            return error;
        }

        public void setError(int error) {
            this.error = error;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<ResultsBean> getResults() {
            return results;
        }

        public void setResults(List<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * currentCity : 成都
             * pm25 : 77
             * index : [{"des":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。","tipt":"穿衣指数","title":"穿衣","zs":"炎热"},{"des":"适宜洗车，未来持续两天无雨天气较好，适合擦洗汽车，蓝天白云、风和日丽将伴您的车子连日洁净。","tipt":"洗车指数","title":"洗车","zs":"适宜"},{"des":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。","tipt":"感冒指数","title":"感冒","zs":"少发"},{"des":"天气较好，较适宜进行各种运动，但考虑气温较高且湿度较大，请适当降低运动强度，并及时补充水分。","tipt":"运动指数","title":"运动","zs":"较适宜"},{"des":"紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。","tipt":"紫外线强度指数","title":"紫外线强度","zs":"很强"}]
             * weather_data : [{"date":"周三 08月26日 (实时：26℃)","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/qing.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"晴","wind":"无持续风向微风","temperature":"32 ~ 21℃"},{"date":"周四","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/qing.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/qing.png","weather":"晴","wind":"无持续风向微风","temperature":"31 ~ 22℃"},{"date":"周五","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/zhenyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/zhenyu.png","weather":"阵雨","wind":"无持续风向微风","temperature":"31 ~ 22℃"},{"date":"周六","dayPictureUrl":"http://api.map.baidu.com/images/weather/day/xiaoyu.png","nightPictureUrl":"http://api.map.baidu.com/images/weather/night/xiaoyu.png","weather":"小雨","wind":"无持续风向微风","temperature":"29 ~ 23℃"}]
             */

            private String currentCity;
            private String pm25;
            private List<IndexBean> index;
            private List<WeatherDataBean> weather_data;

            public String getCurrentCity() {
                return currentCity;
            }

            public void setCurrentCity(String currentCity) {
                this.currentCity = currentCity;
            }

            public String getPm25() {
                return pm25;
            }

            public void setPm25(String pm25) {
                this.pm25 = pm25;
            }

            public List<IndexBean> getIndex() {
                return index;
            }

            public void setIndex(List<IndexBean> index) {
                this.index = index;
            }

            public List<WeatherDataBean> getWeather_data() {
                return weather_data;
            }

            public void setWeather_data(List<WeatherDataBean> weather_data) {
                this.weather_data = weather_data;
            }

            public static class IndexBean {
                /**
                 * des : 天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。
                 * tipt : 穿衣指数
                 * title : 穿衣
                 * zs : 炎热
                 */

                private String des;
                private String tipt;
                private String title;
                private String zs;

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }

                public String getTipt() {
                    return tipt;
                }

                public void setTipt(String tipt) {
                    this.tipt = tipt;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getZs() {
                    return zs;
                }

                public void setZs(String zs) {
                    this.zs = zs;
                }
            }

            public static class WeatherDataBean {
                /**
                 * date : 周三 08月26日 (实时：26℃)
                 * dayPictureUrl : http://api.map.baidu.com/images/weather/day/qing.png
                 * nightPictureUrl : http://api.map.baidu.com/images/weather/night/qing.png
                 * weather : 晴
                 * wind : 无持续风向微风
                 * temperature : 32 ~ 21℃
                 */

                private String date;
                private String dayPictureUrl;
                private String nightPictureUrl;
                private String weather;
                private String wind;
                private String temperature;

                public String getDate() {
                    return date;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public String getDayPictureUrl() {
                    return dayPictureUrl;
                }

                public void setDayPictureUrl(String dayPictureUrl) {
                    this.dayPictureUrl = dayPictureUrl;
                }

                public String getNightPictureUrl() {
                    return nightPictureUrl;
                }

                public void setNightPictureUrl(String nightPictureUrl) {
                    this.nightPictureUrl = nightPictureUrl;
                }

                public String getWeather() {
                    return weather;
                }

                public void setWeather(String weather) {
                    this.weather = weather;
                }

                public String getWind() {
                    return wind;
                }

                public void setWind(String wind) {
                    this.wind = wind;
                }

                public String getTemperature() {
                    return temperature;
                }

                public void setTemperature(String temperature) {
                    this.temperature = temperature;
                }
            }
        }
    }
}
