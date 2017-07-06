package com.glidedemo.zhuxiao.glidedemo.Bean;

import java.util.List;

/**
 * Created by zhuxiao on 2016/5/11.
 */
public class GiphyBean {

    /**
     * status : 200
     * msg : OK
     */

    private MetaBean meta;
    /**
     * total_count : 1947
     * count : 25
     * offset : 0
     */

    private PaginationBean pagination;
    /**
     * type : gif
     * id : FiGiRei2ICzzG
     * slug : funny-cat-FiGiRei2ICzzG
     * url : http://giphy.com/gifs/funny-cat-FiGiRei2ICzzG
     * bitly_gif_url : http://gph.is/1fIdLOl
     * bitly_url : http://gph.is/1fIdLOl
     * embed_url : http://giphy.com/embed/FiGiRei2ICzzG
     * username :
     * source : http://tumblr.com
     * rating : g
     * caption :
     * content_url :
     * source_tld : tumblr.com
     * source_post_url : http://tumblr.com
     * import_datetime : 2014-01-18 09:14:20
     * trending_datetime : 1970-01-01 00:00:00
     * images : {"fixed_height":{"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/200.gif","width":"568","height":"200","size":"460622","mp4":"http://media2.giphy.com/media/FiGiRei2ICzzG/200.mp4","mp4_size":"13866","webp":"http://media2.giphy.com/media/FiGiRei2ICzzG/200.webp","webp_size":"367786"},"fixed_height_still":{"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/200_s.gif","width":"568","height":"200"},"fixed_height_downsampled":{"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/200_d.gif","width":"568","height":"200","size":"476276","webp":"http://media2.giphy.com/media/FiGiRei2ICzzG/200_d.webp","webp_size":"100890"},"fixed_width":{"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/200w.gif","width":"200","height":"70","size":"90483","mp4":"http://media2.giphy.com/media/FiGiRei2ICzzG/200w.mp4","mp4_size":"14238","webp":"http://media2.giphy.com/media/FiGiRei2ICzzG/200w.webp","webp_size":"47302"},"fixed_width_still":{"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/200w_s.gif","width":"200","height":"70"},"fixed_width_downsampled":{"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/200w_d.gif","width":"200","height":"70","size":"71069","webp":"http://media2.giphy.com/media/FiGiRei2ICzzG/200w_d.webp","webp_size":"13186"},"fixed_height_small":{"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/100.gif","width":"284","height":"100","size":"460622","webp":"http://media2.giphy.com/media/FiGiRei2ICzzG/100.webp","webp_size":"72748"},"fixed_height_small_still":{"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/100_s.gif","width":"284","height":"100"},"fixed_width_small":{"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/100w.gif","width":"100","height":"35","size":"90483","webp":"http://media2.giphy.com/media/FiGiRei2ICzzG/100w.webp","webp_size":"18298"},"fixed_width_small_still":{"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/100w_s.gif","width":"100","height":"35"},"downsized":{"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/giphy.gif","width":"500","height":"176","size":"426811"},"downsized_still":{"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/giphy_s.gif","width":"500","height":"176"},"downsized_large":{"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/giphy.gif","width":"500","height":"176","size":"426811"},"original":{"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/giphy.gif","width":"500","height":"176","size":"426811","frames":"22","mp4":"http://media2.giphy.com/media/FiGiRei2ICzzG/giphy.mp4","mp4_size":"51432","webp":"http://media2.giphy.com/media/FiGiRei2ICzzG/giphy.webp","webp_size":"291616"},"original_still":{"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/giphy_s.gif","width":"500","height":"176"}}
     */

    private List<DataBean> data;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public PaginationBean getPagination() {
        return pagination;
    }

    public void setPagination(PaginationBean pagination) {
        this.pagination = pagination;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class MetaBean {
        private int status;
        private String msg;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public static class PaginationBean {
        private int total_count;
        private int count;
        private int offset;

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }
    }

    public static class DataBean {
        private String type;
        private String id;
        private String slug;
        private String url;
        private String bitly_gif_url;
        private String bitly_url;
        private String embed_url;
        private String username;
        private String source;
        private String rating;
        private String caption;
        private String content_url;
        private String source_tld;
        private String source_post_url;
        private String import_datetime;
        private String trending_datetime;
        /**
         * fixed_height : {"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/200.gif","width":"568","height":"200","size":"460622","mp4":"http://media2.giphy.com/media/FiGiRei2ICzzG/200.mp4","mp4_size":"13866","webp":"http://media2.giphy.com/media/FiGiRei2ICzzG/200.webp","webp_size":"367786"}
         * fixed_height_still : {"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/200_s.gif","width":"568","height":"200"}
         * fixed_height_downsampled : {"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/200_d.gif","width":"568","height":"200","size":"476276","webp":"http://media2.giphy.com/media/FiGiRei2ICzzG/200_d.webp","webp_size":"100890"}
         * fixed_width : {"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/200w.gif","width":"200","height":"70","size":"90483","mp4":"http://media2.giphy.com/media/FiGiRei2ICzzG/200w.mp4","mp4_size":"14238","webp":"http://media2.giphy.com/media/FiGiRei2ICzzG/200w.webp","webp_size":"47302"}
         * fixed_width_still : {"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/200w_s.gif","width":"200","height":"70"}
         * fixed_width_downsampled : {"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/200w_d.gif","width":"200","height":"70","size":"71069","webp":"http://media2.giphy.com/media/FiGiRei2ICzzG/200w_d.webp","webp_size":"13186"}
         * fixed_height_small : {"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/100.gif","width":"284","height":"100","size":"460622","webp":"http://media2.giphy.com/media/FiGiRei2ICzzG/100.webp","webp_size":"72748"}
         * fixed_height_small_still : {"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/100_s.gif","width":"284","height":"100"}
         * fixed_width_small : {"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/100w.gif","width":"100","height":"35","size":"90483","webp":"http://media2.giphy.com/media/FiGiRei2ICzzG/100w.webp","webp_size":"18298"}
         * fixed_width_small_still : {"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/100w_s.gif","width":"100","height":"35"}
         * downsized : {"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/giphy.gif","width":"500","height":"176","size":"426811"}
         * downsized_still : {"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/giphy_s.gif","width":"500","height":"176"}
         * downsized_large : {"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/giphy.gif","width":"500","height":"176","size":"426811"}
         * original : {"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/giphy.gif","width":"500","height":"176","size":"426811","frames":"22","mp4":"http://media2.giphy.com/media/FiGiRei2ICzzG/giphy.mp4","mp4_size":"51432","webp":"http://media2.giphy.com/media/FiGiRei2ICzzG/giphy.webp","webp_size":"291616"}
         * original_still : {"url":"http://media2.giphy.com/media/FiGiRei2ICzzG/giphy_s.gif","width":"500","height":"176"}
         */

        private ImagesBean images;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getBitly_gif_url() {
            return bitly_gif_url;
        }

        public void setBitly_gif_url(String bitly_gif_url) {
            this.bitly_gif_url = bitly_gif_url;
        }

        public String getBitly_url() {
            return bitly_url;
        }

        public void setBitly_url(String bitly_url) {
            this.bitly_url = bitly_url;
        }

        public String getEmbed_url() {
            return embed_url;
        }

        public void setEmbed_url(String embed_url) {
            this.embed_url = embed_url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getContent_url() {
            return content_url;
        }

        public void setContent_url(String content_url) {
            this.content_url = content_url;
        }

        public String getSource_tld() {
            return source_tld;
        }

        public void setSource_tld(String source_tld) {
            this.source_tld = source_tld;
        }

        public String getSource_post_url() {
            return source_post_url;
        }

        public void setSource_post_url(String source_post_url) {
            this.source_post_url = source_post_url;
        }

        public String getImport_datetime() {
            return import_datetime;
        }

        public void setImport_datetime(String import_datetime) {
            this.import_datetime = import_datetime;
        }

        public String getTrending_datetime() {
            return trending_datetime;
        }

        public void setTrending_datetime(String trending_datetime) {
            this.trending_datetime = trending_datetime;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public static class ImagesBean {
            /**
             * url : http://media2.giphy.com/media/FiGiRei2ICzzG/200.gif
             * width : 568
             * height : 200
             * size : 460622
             * mp4 : http://media2.giphy.com/media/FiGiRei2ICzzG/200.mp4
             * mp4_size : 13866
             * webp : http://media2.giphy.com/media/FiGiRei2ICzzG/200.webp
             * webp_size : 367786
             */

            private FixedHeightBean fixed_height;
            /**
             * url : http://media2.giphy.com/media/FiGiRei2ICzzG/200_s.gif
             * width : 568
             * height : 200
             */

            private FixedHeightStillBean fixed_height_still;
            /**
             * url : http://media2.giphy.com/media/FiGiRei2ICzzG/200_d.gif
             * width : 568
             * height : 200
             * size : 476276
             * webp : http://media2.giphy.com/media/FiGiRei2ICzzG/200_d.webp
             * webp_size : 100890
             */

            private FixedHeightDownsampledBean fixed_height_downsampled;
            /**
             * url : http://media2.giphy.com/media/FiGiRei2ICzzG/200w.gif
             * width : 200
             * height : 70
             * size : 90483
             * mp4 : http://media2.giphy.com/media/FiGiRei2ICzzG/200w.mp4
             * mp4_size : 14238
             * webp : http://media2.giphy.com/media/FiGiRei2ICzzG/200w.webp
             * webp_size : 47302
             */

            private FixedWidthBean fixed_width;
            /**
             * url : http://media2.giphy.com/media/FiGiRei2ICzzG/200w_s.gif
             * width : 200
             * height : 70
             */

            private FixedWidthStillBean fixed_width_still;
            /**
             * url : http://media2.giphy.com/media/FiGiRei2ICzzG/200w_d.gif
             * width : 200
             * height : 70
             * size : 71069
             * webp : http://media2.giphy.com/media/FiGiRei2ICzzG/200w_d.webp
             * webp_size : 13186
             */

            private FixedWidthDownsampledBean fixed_width_downsampled;
            /**
             * url : http://media2.giphy.com/media/FiGiRei2ICzzG/100.gif
             * width : 284
             * height : 100
             * size : 460622
             * webp : http://media2.giphy.com/media/FiGiRei2ICzzG/100.webp
             * webp_size : 72748
             */

            private FixedHeightSmallBean fixed_height_small;
            /**
             * url : http://media2.giphy.com/media/FiGiRei2ICzzG/100_s.gif
             * width : 284
             * height : 100
             */

            private FixedHeightSmallStillBean fixed_height_small_still;
            /**
             * url : http://media2.giphy.com/media/FiGiRei2ICzzG/100w.gif
             * width : 100
             * height : 35
             * size : 90483
             * webp : http://media2.giphy.com/media/FiGiRei2ICzzG/100w.webp
             * webp_size : 18298
             */

            private FixedWidthSmallBean fixed_width_small;
            /**
             * url : http://media2.giphy.com/media/FiGiRei2ICzzG/100w_s.gif
             * width : 100
             * height : 35
             */

            private FixedWidthSmallStillBean fixed_width_small_still;
            /**
             * url : http://media2.giphy.com/media/FiGiRei2ICzzG/giphy.gif
             * width : 500
             * height : 176
             * size : 426811
             */

            private DownsizedBean downsized;
            /**
             * url : http://media2.giphy.com/media/FiGiRei2ICzzG/giphy_s.gif
             * width : 500
             * height : 176
             */

            private DownsizedStillBean downsized_still;
            /**
             * url : http://media2.giphy.com/media/FiGiRei2ICzzG/giphy.gif
             * width : 500
             * height : 176
             * size : 426811
             */

            private DownsizedLargeBean downsized_large;
            /**
             * url : http://media2.giphy.com/media/FiGiRei2ICzzG/giphy.gif
             * width : 500
             * height : 176
             * size : 426811
             * frames : 22
             * mp4 : http://media2.giphy.com/media/FiGiRei2ICzzG/giphy.mp4
             * mp4_size : 51432
             * webp : http://media2.giphy.com/media/FiGiRei2ICzzG/giphy.webp
             * webp_size : 291616
             */

            private OriginalBean original;
            /**
             * url : http://media2.giphy.com/media/FiGiRei2ICzzG/giphy_s.gif
             * width : 500
             * height : 176
             */

            private OriginalStillBean original_still;

            public FixedHeightBean getFixed_height() {
                return fixed_height;
            }

            public void setFixed_height(FixedHeightBean fixed_height) {
                this.fixed_height = fixed_height;
            }

            public FixedHeightStillBean getFixed_height_still() {
                return fixed_height_still;
            }

            public void setFixed_height_still(FixedHeightStillBean fixed_height_still) {
                this.fixed_height_still = fixed_height_still;
            }

            public FixedHeightDownsampledBean getFixed_height_downsampled() {
                return fixed_height_downsampled;
            }

            public void setFixed_height_downsampled(FixedHeightDownsampledBean fixed_height_downsampled) {
                this.fixed_height_downsampled = fixed_height_downsampled;
            }

            public FixedWidthBean getFixed_width() {
                return fixed_width;
            }

            public void setFixed_width(FixedWidthBean fixed_width) {
                this.fixed_width = fixed_width;
            }

            public FixedWidthStillBean getFixed_width_still() {
                return fixed_width_still;
            }

            public void setFixed_width_still(FixedWidthStillBean fixed_width_still) {
                this.fixed_width_still = fixed_width_still;
            }

            public FixedWidthDownsampledBean getFixed_width_downsampled() {
                return fixed_width_downsampled;
            }

            public void setFixed_width_downsampled(FixedWidthDownsampledBean fixed_width_downsampled) {
                this.fixed_width_downsampled = fixed_width_downsampled;
            }

            public FixedHeightSmallBean getFixed_height_small() {
                return fixed_height_small;
            }

            public void setFixed_height_small(FixedHeightSmallBean fixed_height_small) {
                this.fixed_height_small = fixed_height_small;
            }

            public FixedHeightSmallStillBean getFixed_height_small_still() {
                return fixed_height_small_still;
            }

            public void setFixed_height_small_still(FixedHeightSmallStillBean fixed_height_small_still) {
                this.fixed_height_small_still = fixed_height_small_still;
            }

            public FixedWidthSmallBean getFixed_width_small() {
                return fixed_width_small;
            }

            public void setFixed_width_small(FixedWidthSmallBean fixed_width_small) {
                this.fixed_width_small = fixed_width_small;
            }

            public FixedWidthSmallStillBean getFixed_width_small_still() {
                return fixed_width_small_still;
            }

            public void setFixed_width_small_still(FixedWidthSmallStillBean fixed_width_small_still) {
                this.fixed_width_small_still = fixed_width_small_still;
            }

            public DownsizedBean getDownsized() {
                return downsized;
            }

            public void setDownsized(DownsizedBean downsized) {
                this.downsized = downsized;
            }

            public DownsizedStillBean getDownsized_still() {
                return downsized_still;
            }

            public void setDownsized_still(DownsizedStillBean downsized_still) {
                this.downsized_still = downsized_still;
            }

            public DownsizedLargeBean getDownsized_large() {
                return downsized_large;
            }

            public void setDownsized_large(DownsizedLargeBean downsized_large) {
                this.downsized_large = downsized_large;
            }

            public OriginalBean getOriginal() {
                return original;
            }

            public void setOriginal(OriginalBean original) {
                this.original = original;
            }

            public OriginalStillBean getOriginal_still() {
                return original_still;
            }

            public void setOriginal_still(OriginalStillBean original_still) {
                this.original_still = original_still;
            }

            public static class FixedHeightBean {
                private String url;
                private String width;
                private String height;
                private String size;
                private String mp4;
                private String mp4_size;
                private String webp;
                private String webp_size;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public String getMp4() {
                    return mp4;
                }

                public void setMp4(String mp4) {
                    this.mp4 = mp4;
                }

                public String getMp4_size() {
                    return mp4_size;
                }

                public void setMp4_size(String mp4_size) {
                    this.mp4_size = mp4_size;
                }

                public String getWebp() {
                    return webp;
                }

                public void setWebp(String webp) {
                    this.webp = webp;
                }

                public String getWebp_size() {
                    return webp_size;
                }

                public void setWebp_size(String webp_size) {
                    this.webp_size = webp_size;
                }
            }

            public static class FixedHeightStillBean {
                private String url;
                private String width;
                private String height;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }
            }

            public static class FixedHeightDownsampledBean {
                private String url;
                private String width;
                private String height;
                private String size;
                private String webp;
                private String webp_size;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public String getWebp() {
                    return webp;
                }

                public void setWebp(String webp) {
                    this.webp = webp;
                }

                public String getWebp_size() {
                    return webp_size;
                }

                public void setWebp_size(String webp_size) {
                    this.webp_size = webp_size;
                }
            }

            public static class FixedWidthBean {
                private String url;
                private String width;
                private String height;
                private String size;
                private String mp4;
                private String mp4_size;
                private String webp;
                private String webp_size;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public String getMp4() {
                    return mp4;
                }

                public void setMp4(String mp4) {
                    this.mp4 = mp4;
                }

                public String getMp4_size() {
                    return mp4_size;
                }

                public void setMp4_size(String mp4_size) {
                    this.mp4_size = mp4_size;
                }

                public String getWebp() {
                    return webp;
                }

                public void setWebp(String webp) {
                    this.webp = webp;
                }

                public String getWebp_size() {
                    return webp_size;
                }

                public void setWebp_size(String webp_size) {
                    this.webp_size = webp_size;
                }
            }

            public static class FixedWidthStillBean {
                private String url;
                private String width;
                private String height;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }
            }

            public static class FixedWidthDownsampledBean {
                private String url;
                private String width;
                private String height;
                private String size;
                private String webp;
                private String webp_size;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public String getWebp() {
                    return webp;
                }

                public void setWebp(String webp) {
                    this.webp = webp;
                }

                public String getWebp_size() {
                    return webp_size;
                }

                public void setWebp_size(String webp_size) {
                    this.webp_size = webp_size;
                }
            }

            public static class FixedHeightSmallBean {
                private String url;
                private String width;
                private String height;
                private String size;
                private String webp;
                private String webp_size;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public String getWebp() {
                    return webp;
                }

                public void setWebp(String webp) {
                    this.webp = webp;
                }

                public String getWebp_size() {
                    return webp_size;
                }

                public void setWebp_size(String webp_size) {
                    this.webp_size = webp_size;
                }
            }

            public static class FixedHeightSmallStillBean {
                private String url;
                private String width;
                private String height;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }
            }

            public static class FixedWidthSmallBean {
                private String url;
                private String width;
                private String height;
                private String size;
                private String webp;
                private String webp_size;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public String getWebp() {
                    return webp;
                }

                public void setWebp(String webp) {
                    this.webp = webp;
                }

                public String getWebp_size() {
                    return webp_size;
                }

                public void setWebp_size(String webp_size) {
                    this.webp_size = webp_size;
                }
            }

            public static class FixedWidthSmallStillBean {
                private String url;
                private String width;
                private String height;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }
            }

            public static class DownsizedBean {
                private String url;
                private String width;
                private String height;
                private String size;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }
            }

            public static class DownsizedStillBean {
                private String url;
                private String width;
                private String height;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }
            }

            public static class DownsizedLargeBean {
                private String url;
                private String width;
                private String height;
                private String size;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }
            }

            public static class OriginalBean {
                private String url;
                private String width;
                private String height;
                private String size;
                private String frames;
                private String mp4;
                private String mp4_size;
                private String webp;
                private String webp_size;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public String getFrames() {
                    return frames;
                }

                public void setFrames(String frames) {
                    this.frames = frames;
                }

                public String getMp4() {
                    return mp4;
                }

                public void setMp4(String mp4) {
                    this.mp4 = mp4;
                }

                public String getMp4_size() {
                    return mp4_size;
                }

                public void setMp4_size(String mp4_size) {
                    this.mp4_size = mp4_size;
                }

                public String getWebp() {
                    return webp;
                }

                public void setWebp(String webp) {
                    this.webp = webp;
                }

                public String getWebp_size() {
                    return webp_size;
                }

                public void setWebp_size(String webp_size) {
                    this.webp_size = webp_size;
                }
            }

            public static class OriginalStillBean {
                private String url;
                private String width;
                private String height;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }
            }
        }
    }
}
